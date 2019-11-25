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
 * Das ListModel für die Fächer
 * 
 * @author fielesebastian
 */
public class FachListModel extends AbstractListModel {
    
    /* Daten für das ListModel */
    private List<Fach> faecher = new ArrayList<>();

    /** 
     * Konstruktor für Fächer
     * 
     * @param faecher 
     */
    public FachListModel(List<Fach> faecher) {
        this.faecher = faecher;
    }
    
    /**
     * Größe der Fächerliste ausgeben
     * 
     * @return 
     */
    @Override
    public int getSize() {
        return faecher.size();
    }

    /**
     * Element an Index finden
     * 
     * @param index
     * @return 
     */
    @Override
    public Object getElementAt(int index) {
        return index >= faecher.size() ? null : faecher.get(index);
    }
}
