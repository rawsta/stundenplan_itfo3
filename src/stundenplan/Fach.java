/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

/**
 * Die "Fach"-Klasse
 * @author ellinghannah
 */
public class Fach {
    private int id;
    private String name;
    private String kuerzel;

    /**
     * Der Konstruktor
     * 
     * @param id
     * @param name
     * @param kuerzel 
     */
    public Fach(int id, String name, String kuerzel) {
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
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
