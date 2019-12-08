/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

/**
 *
 * @author hannah.elling
 */
public class AktivitaetTriplet {

    private final int id;
    private final String lehrer;
    private final String klasse;
    private final String fach;

    public AktivitaetTriplet(int id, String lehrer, String klasse, String fach) {
        this.lehrer = lehrer;
        this.klasse = klasse;
        this.fach = fach;
        this.id = id;
    }

    public int getId() { return id; }
    public String getLehrer() { return lehrer; }
    public String getKlasse() { return klasse; }
    public String getFach() { return fach; }
}
