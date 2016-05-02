package ohtu;

import javax.swing.JTextField;
import ohtu.Komento;
import ohtu.Sovelluslogiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mikosty
 */
public class Erotus implements Komento {

    private Sovelluslogiikka sl;
    private JTextField tk;
    private JTextField st;
    private int previous;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sl = sovellus;
        this.tk = tuloskentta;
        this.st = syotekentta;
        this.previous = 0;
    }

    @Override
    public void suorita() {
        try {
            previous = Integer.parseInt(tk.getText());
        } catch (Exception e) {
        }

        int arvo = 0;

        try {
            arvo = Integer.parseInt(st.getText());
        } catch (Exception e) {
        }
        sl.miinus(arvo);
        tk.setText("" + sl.tulos());
        st.setText("" + 0);
    }

    @Override
    public void peru() {
        sl.plus(previous);

        tk.setText("" + sl.tulos());
    }

}
