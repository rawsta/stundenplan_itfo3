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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioritaet() {
        return prioritaet;
    }

    public void setPrioritaet(int prioritaet) {
        this.prioritaet = prioritaet;
    }

    public Fach getFach() {
        return fach;
    }

    public void setFach(Fach fach) {
        this.fach = fach;
    }

    public Lehrer getLehrer() {
        return lehrer;
    }

    public void setLehrer(Lehrer lehrer) {
        this.lehrer = lehrer;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public boolean isVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }
    
    
}
