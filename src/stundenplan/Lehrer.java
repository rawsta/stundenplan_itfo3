/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ellinghannah
 */
public class Lehrer {
    private int id;
    private String name;
    private String kuerzel;
    private List<Klasse> klassen;
    private Fach[] faecher;
    private Unterrichtseinheit[] stunden;

    public Lehrer(int id, String name, String kuerzel) {
        this.id = id;
        this.name = name;
        this.kuerzel = kuerzel;
    }
    
    
}
