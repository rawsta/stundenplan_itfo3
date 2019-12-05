/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.util.List;

/**
 * Die "Klasse"-Klasse
 */
public class Klasse {
    private int id;
    private String kuerzel;
    private Unterrichtseinheit[] unterricht;
    private List<Lehrer> lehrerList;

    /**
     * Der Konstruktor
     * 
     * @param id
     * @param kuerzel 
     */
    public Klasse(int id, String kuerzel) {
        this.id = id;
        this.kuerzel = kuerzel;
    }    

    /* ----------- Getter & Setter ----------- */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public Unterrichtseinheit[] getUnterricht() {
        return unterricht;
    }

    public void setUnterricht(Unterrichtseinheit[] unterricht) {
        this.unterricht = unterricht;
    }

    public List<Lehrer> getLehrerList() {
        return lehrerList;
    }

    public void setLehrerList(List<Lehrer> lehrerList) {
        this.lehrerList = lehrerList;
    }
    
    @Override
    public String toString() {
        return this.kuerzel;
    }
    
}
