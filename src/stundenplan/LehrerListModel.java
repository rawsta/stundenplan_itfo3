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
 *
 * @author rawsta
 */
public class LehrerListModel extends AbstractListModel {
    
    /* Daten für das ListModel */
    private List<Lehrer> lehrer = new ArrayList<>();

    /** 
     * constructor
     * @param lehrer 
     */
    public LehrerListModel(List<Lehrer> lehrer) {
        this.lehrer = lehrer;
    }
    
    
    @Override
    public int getSize() {
        return lehrer.size();
    }


    @Override
    public Object getElementAt(int index) {
        
        Lehrer tempLehrer = lehrer.get(index);
        
        return tempLehrer.getName();
    }
    
}
