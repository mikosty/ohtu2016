package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka21");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep223");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep223");
        element = driver.findElement(By.name("add"));
        
        
        
        element.submit();
  
        WebElement element2 = driver.findElement(By.linkText("continue to application mainpage"));       
        element2.click();
        
        WebElement element3 = driver.findElement(By.linkText("logout"));       
        element3.click(); 
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
    }
}
