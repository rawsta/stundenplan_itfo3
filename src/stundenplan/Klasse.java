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

    public Klasse(int id, String name) {
        this.id = id;
        this.name = name;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unterrichtseinheit[] getUnterricht() {
        return unterricht;
    }

    public void setUnterricht(Unterrichtseinheit[] unterricht) {
        this.unterricht = unterricht;
    }

    public List<Lehrer> getLehrerList() {
        return lehrerList;
    }

    public void setLehrerList(List<Lehrer> lehrerList) {
        this.lehrerList = lehrerList;
    }
    
    
}
