/*
 * Mit diesem Interface wird es leichter die zenbtrale Datenbank anzusprechen.
 * Alle Methoden die in der Datenbank.java vorhanden sind, müssen hier ebenso implementiert werden.
 * 
 */
package stundenplan.datenbank;

import java.sql.ResultSet;
import java.util.List;

import stundenplan.Aktivitaet;
import stundenplan.Fach;
import stundenplan.Klasse;
import stundenplan.Lehrer;
import stundenplan.AktivitaetTriplet;

/**
 * Interface Klasse für die Datenbank
 * @author fielesebastian
 */
public interface IConnection {
       
   /**
    * Datenbank öffnen
    */
   public void oeffneVerbindung();

   /**
    * Datenbank schliessen
    */
   public void schliesseVerbindung();
    
    
    /* ------------------------- Klassen ------------------------- */
        
    /**
    * Hole Klassen aus Datenbank
    * 
    * @return Liste der Klassen
    */
   public List<Klasse> holeKlassen();

   /**
    * Klasse in DB schreiben
    * 
    * @param kuerzel
    */
   public void neueKlasse(String kuerzel);
   
   /**
    * Hole Klasse aus Datenbank
    * 
    * @param kuerzel
    * @return Liste der Klasse
    */
   public Klasse getSelectedKlasse(String kuerzel);

   /**
    * Klasse aktualisieren
    * 
    * @param id
    * @param kuerzel
    */
   public void updateKlasse(int id, String kuerzel);
   
   public void loescheKlasse(int id);


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
    * @param name
    * @return Liste der Lehrer
    */
   public Lehrer getSelectedLehrer(String name);

   /**
    * Lehrer in DB schreiben
    *
     * @param kuerzel
     * @param name
     * @param verfuegbarkeit
    */
   public void neuerLehrer(String kuerzel, String name, Boolean[][] verfuegbarkeit);

   /**
    * Lehrer aktualisieren
    *
     * @param id
     * @param kuerzel
     * @param name
     * @param verfuegbarkeit
    */
   public void updateLehrer(int id, String kuerzel, String name, Boolean[][] verfuegbarkeit);
   
   public void loescheLehrer(String name);


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
   public List<Fach> holeFaecher();
   
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

   public List<Aktivitaet> holeAktivitaeten();
   
   public void loescheAlleAktivitaeten();

   public AktivitaetTriplet convertRowToTripletAktivitaet(ResultSet resultSet);
   
}
