/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import javafx.util.Pair;

/**
 *
 * @author ellinghannah
 */
public class Aktivitaet {
    private Klasse klasse;
    private Pair<Lehrer, Lehrer> lehreinheit;
    private Fach fach;

    public Aktivitaet(Klasse klasse, Pair<Lehrer, Lehrer> lehreinheit, Fach fach) {
        this.klasse = klasse;
        this.lehreinheit = lehreinheit;
        this.fach = fach;
    }
    
}
