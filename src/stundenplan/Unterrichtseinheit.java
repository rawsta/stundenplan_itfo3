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
}
