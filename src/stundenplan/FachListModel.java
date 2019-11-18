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
 *
 * @author fielesebastian
 */
public class FachListModel extends AbstractListModel {
    
    /* Daten für das ListModel */
    private List<Fach> faecher = new ArrayList<>();

    /** 
     * constructor 
     * @param faecher 
     */
    public FachListModel(List<Fach> faecher) {
        this.faecher = faecher;
    }
    
    
    @Override
    public int getSize() {
        return faecher.size();
    }


    @Override
    public Object getElementAt(int index) {
        
        Fach tempKlasse = faecher.get(index);
        
        return tempKlasse.getName();
    }
}
