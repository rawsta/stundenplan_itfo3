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
public class Klasse {
    private int id;
    private String name;
    private Unterrichtseinheit[] unterricht;
    private List<Lehrer> lehrerList;

    public Klasse(int id, String name, Unterrichtseinheit[] unterricht, List<Lehrer> lehrerList) {
        this.id = id;
        this.name = name;
        this.unterricht = unterricht;
        this.lehrerList = lehrerList;
    }    
     
}
