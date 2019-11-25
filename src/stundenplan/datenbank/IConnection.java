/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan.datenbank;

import java.sql.ResultSet;
import java.util.List;
import stundenplan.Fach;
import stundenplan.Klasse;
import stundenplan.Lehrer;

/**
 * Interface Klasse für die Datenbank
 * @author fielesebastian
 */
public interface IConnection {
       
   /**
    * Datenbank öffnen
    */
   public void openConnection();

   /**
    * Datenbank schliessen
    */
   public void closeConnection();
    
    
    /* ------------------------- Klassen ------------------------- */
        
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
   public Klasse convertRowToKlasse(ResultSet results);
   
   
   /* ------------------------- Lehrer ------------------------- */
   
   /**
    * Hole Lehrer aus Datenbank
    * 
    * @return Liste der Lehrer
    */
   public List<Lehrer> holeLehrer();
   
   /**
    * Hole Lehrer aus Datenbank
    * 
    * @param auswahl
    * @return Liste der Lehrer
    */
   public Lehrer getSelectedLehrer(String auswahl);

   /**
    * Lehrer in DB schreiben
    * 
    * @param lehrer
    */
   public void neuerLehrer(Lehrer lehrer);

   /**
    * Lehrer aktualisieren
    * 
    * @param name
    * @param lehrer
    */
   public void updateLehrer(String name, Lehrer lehrer);


   /**
    * Konvertiert TabelRow zu Lehrer
    * 
    * @param results
    * @return lehrer object
    */
   public Lehrer convertRowToLehrer(ResultSet results);
   

   /* ------------------------- Faecher ------------------------- */
   /**
    * Hole Fach aus Datenbank
    * 
    * @return Liste der Fächer
    */
   public List<Fach> holeFach();
   
   /**
    * Hole Fach aus Datenbank
    * 
    * @param auswahl
    * @return ausgewähltes Fach
    */
   public Fach getSelectedFach(String auswahl);

   /**
    * Fach in DB schreiben
    * 
    * @param fach
    */
   public void neuesFach(Fach fach);

   /**
    * Fach aktualisieren
    * 
    * @param name
    * @param faecher
    */
   public void updateFach(String name, Fach faecher);

   /**
    * Konvertiert TabelRow zu Fach
    * 
    * @param results
    * @return Fach object
    */
   public Fach convertRowToFach(ResultSet results);
   
}