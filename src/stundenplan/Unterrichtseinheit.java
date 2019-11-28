/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.time.DayOfWeek;
import javafx.util.Pair;

/**
 * Die Unterrichtseinheit Klasse
 * @author ellinghannah
 */
public class Unterrichtseinheit {
    private DayOfWeek tag;
    private int block;
    private Klasse klasse;
    private Pair<Lehrer, Lehrer> lehreinheit;

    /**
     * Unterrichtseinheit Konstruktor
     * 
     * @param tag
     * @param block
     * @param klasse
     * @param lehreinheit 
     */
    public Unterrichtseinheit(DayOfWeek tag, int block, Klasse klasse, Pair<Lehrer, Lehrer> lehreinheit) {
        this.tag = tag;
        this.block = block;
        this.klasse = klasse;
        this.lehreinheit = lehreinheit;
    }

    /* ----------- Getter & Setter ----------- */
    
    public DayOfWeek getTag() {
        return tag;
    }

    public void setTag(DayOfWeek tag) {
        this.tag = tag;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

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
    
    
}
