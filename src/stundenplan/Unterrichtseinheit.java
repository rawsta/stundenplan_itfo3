/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.time.DayOfWeek;
import javafx.util.Pair;

/**
 *
 * @author ellinghannah
 */
public class Unterrichtseinheit {
    private DayOfWeek tag;
    private int block;
    private Klasse klasse;
    private Pair<Lehrer, Lehrer> lehreinheit;

    public Unterrichtseinheit(DayOfWeek tag, int block, Klasse klasse, Pair<Lehrer, Lehrer> lehreinheit) {
        this.tag = tag;
        this.block = block;
        this.klasse = klasse;
        this.lehreinheit = lehreinheit;
    }
}
