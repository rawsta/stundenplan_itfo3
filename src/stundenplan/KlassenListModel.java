/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import javax.swing.AbstractListModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Das ListModel für die Klassen
 * 
 * @author fielesebastian
 */
public class KlassenListModel extends AbstractListModel {
    
    /* Daten für das ListModel */
    private List<Klasse> klassen = new ArrayList<>();

    /** 
     * Konstruktor für die Klassen
     * 
     * @param klassen 
     */
    public KlassenListModel(List<Klasse> klassen) {
        this.klassen = klassen;
    }
    
    /**
     * Größe der Klassen ausgeben
     * 
     * @return Klassengröße
     */
    @Override
    public int getSize() {
        return klassen.size();
    }

    /**
     * Element an Index finden
     * 
     * @param index
     * @return 
     */
    @Override
    public Object getElementAt(int index) {
        return index >= klassen.size() ? null : klassen.get(index);
    }
}
