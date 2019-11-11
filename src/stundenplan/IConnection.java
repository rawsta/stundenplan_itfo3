/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author rawsta
 */
public interface IConnection {
        
    /**
    * Hole Klassen aus Datenbank
    * 
    * @return Liste der Klassen
    */
   public List<Klasse> holeKlasse();

   /**
    * Klasse in DB schreiben
    * 
    * @param klasse
    */
   public void neueKlasse(Klasse klasse);

   /**
    * Klasse aktualisieren
    * 
    * @param title
    * @param klasse
    */
   public void updateKlasse(String title, Klasse klasse);


   /**
    * Konvertiert TabelRow zu Objekt
    * 
    * @param results
    * @return klasse object
    */
   public Klasse convertRowToObject(ResultSet results);

   /**
    * Datenbank öffnen
    */
   public void openConnection();

   /**
    * datenbank schliessen
    */
   public void closeConnection();
}
