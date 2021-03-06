import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description """A new user account can be created 
              if a proper unused username 
              and a proper password are given"""

scenario "creation succesfull with correct username and password", {
    given 'command new user is selected', {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
       
    }
 
    when 'a valid username and password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka2222");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep223");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep223");
        element = driver.findElement(By.name("add"));
        element.submit();
      
    }

    then 'new user is registered to system', {
        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }
}

scenario "can login with succesfully generated account", {
    given 'command new user is selected', {

    }
 
    when 'a valid username and password are entered', {
    }

    then  'new credentials allow logging in to system', {
    }
}

scenario "creation fails with correct username and too short password", {
    given 'command new user is selected'
    when 'a valid username and too short password are entered'
    then 'new user is not be registered to system'
}

scenario "creation fails with correct username and pasword consisting of letters", {
    given 'command new user is selected'
    when 'a valid username and password consisting of letters are entered'
    then 'new user is not be registered to system'
}

scenario "creation fails with too short username and valid pasword", {
    given 'command new user is selected'
    when 'a too sort username and valid password are entered'
    then 'new user is not be registered to system'
}

scenario "creation fails with already taken username and valid pasword", {
    given 'command new user is selected'
    when 'a already taken username and valid password are entered'
    then 'new user is not be registered to system'
}

scenario "can not login with account that is not succesfully created", {
    given 'command new user is selected'
    when 'a invalid username/password are entered'
    then  'new credentials do not allow logging in to system'
}