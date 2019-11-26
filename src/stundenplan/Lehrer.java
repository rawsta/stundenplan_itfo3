/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.util.List;

/**
 * Die "Lehrer"-Klasse
 * @author ellinghannah
 */
public class Lehrer {
    private int id;
    private String name;
    private String kuerzel;
    private List<Klasse> klassen;
    private Fach[] faecher;
    private Unterrichtseinheit[] stunden;

    /**
     * Der Konstruktor
     * 
     * @param id
     * @param name
     * @param kuerzel 
     */
    public Lehrer(int id, String name, String kuerzel) {
        this.id = id;
        this.name = name;
        this.kuerzel = kuerzel;
    }

    /* ----------- Getter & Setter ----------- */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public List<Klasse> getKlassen() {
        return klassen;
    }

    public void setKlassen(List<Klasse> klassen) {
        this.klassen = klassen;
    }

    public Fach[] getFaecher() {
        return faecher;
    }

    public void setFaecher(Fach[] faecher) {
        this.faecher = faecher;
    }

    public Unterrichtseinheit[] getStunden() {
        return stunden;
    }

    public void setStunden(Unterrichtseinheit[] stunden) {
        this.stunden = stunden;
    }
    
    
}
