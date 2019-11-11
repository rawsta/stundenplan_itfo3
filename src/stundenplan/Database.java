/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rawsta
 */
public class Database implements IConnection{
    
    private Connection connect;
    private Statement statement;

    /**
     * constructor
     */
    public Database() {
        super();
        this.connect = null;
        this.statement = null;
        this.openConnection();
    }

    /**
     * Verbindung aufbauen
     */
    public void openConnection() {
        try {
            if (this.connect == null || this.connect.isClosed()) {
                this.connect = DriverManager.getConnection("jdbc:sqlite:stundenplan.db");
                System.out.println("Datenbank gefunden.");
            }
            if (this.statement == null || this.statement.isClosed()) {
                this.statement = this.connect.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("Konnte mich nicht mit der Datenbank verbinden");
            throw new RuntimeException(e);
        }
    }

    /**
     * Verbindung wieder schliessen
     */
    public void closeConnection() {
        try {
            if (this.statement != null) {
                    this.statement.close();
            }
            if (this.connect != null) {
                    this.connect.close();
            }
            System.out.println("Datenbank wieder geschlossen");
        } catch (SQLException e) {
            System.out.print("Datenbank konnte nicht korrekt geschlossen werden");
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Klassen aus der Dat3enbank auslesen
     * 
     * @return Klassen
     */
    public ArrayList<Klasse> holeKlasse() {
        ArrayList<Klasse> klassen = new ArrayList<>();
        try {
            String query = "SELECT K_ID,Kuerzel FROM Klasse";
            ResultSet results = this.statement.executeQuery(query);
            // wir wandeln ArrayList in Objekt um
            while (results.next()) {
                    klassen.add(convertRowToObject(results));
            }
        } catch (SQLException e) {
                System.out.println("SQLException beim auslesen der Klassen.");
                throw new RuntimeException(e);
        }
        return klassen;
    }

    /**
     * Neue Klasse anlegen
     * 
     * @param klasse
     */
    public void neueKlasse(Klasse klasse) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(
                            "INSERT INTO Klasse (K_ID, Kuerzel) VALUES (?, ?)");
            preparedStatement.setInt(1, klasse.getId());
            preparedStatement.setString(2, klasse.getName());
            preparedStatement.setObject(3, klasse.getUnterricht());
            preparedStatement.setObject(4, klasse.getLehrerList());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQLException - Kann die Klasse nicht einfügen");
            throw new RuntimeException(e);
        }

    }

    /**
     * Klasse aktualisieren
     * 
     * @param title
     * @param klasse
     */
    public void updateKlasse(String title, Klasse klasse) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(
                            "UPDATE Klasse SET K_ID = ?, Kuerzel = ? WHERE title = '" + title + "'");
            preparedStatement.setInt(1, klasse.getId());
            preparedStatement.setString(2, klasse.getName());
            preparedStatement.setObject(3, klasse.getUnterricht());
            preparedStatement.setObject(4, klasse.getLehrerList());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQLException Kann die Klasse nicht aktualisieren");
            throw new RuntimeException(e);
        }

    }

    /**
     * Konvertiert TabelRow zu Objekt
     * 
     * @param results
     * @return
     */
    public Klasse convertRowToObject(ResultSet results) {

        Klasse tempKlasse = null;
        try {
            int k_id = results.getInt("K_ID");
            String kuerzel = results.getString("Kuerzel");

            tempKlasse = new Klasse(k_id, kuerzel);

        } catch (SQLException e) {
            System.out.println("Kann die Klasse nicht aufbauen");
            throw new RuntimeException(e);
        }

        return tempKlasse;
    }


    
}
