/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import javafx.util.Pair;

/**
 * Die "Aktivität"-Klasse
 */
public class Aktivitaet {
    private Klasse klasse;
    private Pair<Lehrer, Lehrer> lehreinheit;
    private Fach fach;

    /**
     * Der Kontruktor
     * 
     * @param klasse
     * @param lehreinheit
     * @param fach 
     */
    public Aktivitaet(Klasse klasse, Pair<Lehrer, Lehrer> lehreinheit, Fach fach) {
        this.klasse = klasse;
        this.lehreinheit = lehreinheit;
        this.fach = fach;
    }

    /* ----------- Getter & Setter ----------- */
    
    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public Pair<Lehrer, Lehrer> getLehreinheit() {
        return lehreinheit;
    }

    public void setLehreinheit(Pair<Lehrer, Lehrer> lehreinheit) {
        this.lehreinheit = lehreinheit;
    }

    public Fach getFach() {
        return fach;
    }

    public void setFach(Fach fach) {
        this.fach = fach;
    }

}
