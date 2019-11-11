/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

/**
 *
 * @author ellinghannah
 */
public class Regel {
    private int id;
    private int prioritaet;
    private Fach fach;
    private Lehrer lehrer;
    private Klasse klasse;
    private boolean verfuegbar;

    public Regel(int id, int prioritaet, Fach fach, Lehrer lehrer, Klasse klasse, boolean verfuegbar) {
        this.id = id;
        this.prioritaet = prioritaet;
        this.fach = fach;
        this.lehrer = lehrer;
        this.klasse = klasse;
        this.verfuegbar = verfuegbar;
    }
    
    
}
