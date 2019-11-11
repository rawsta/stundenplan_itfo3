/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.util.List;

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
}
