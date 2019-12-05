/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Das ListModel für die Lehrer
 * 
 * @author fielesebastian
 */
public class LehrerListModel extends AbstractListModel {
    
    /* Daten für das ListModel */
    private List<Lehrer> lehrer = new ArrayList<>();

    /** 
     * Konstruktor für Lehrer
     * 
     * @param lehrer 
     */
    public LehrerListModel(List<Lehrer> lehrer) {
        this.lehrer = lehrer;
    }
    
    /**
     * Größe der Lehrer Liste ausgeben
     * @return 
     */
    @Override
    public int getSize() {
        return lehrer.size();
    }

    /**
     * Element an Index finden
     * 
     * @param index
     * @return 
     */
    @Override
    public Object getElementAt(int index) {
        return index >= lehrer.size() ? null : lehrer.get(index);
    }
    
}
