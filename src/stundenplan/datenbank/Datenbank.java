/*
 * In dieser Klasse wird die Verbindung und die Abfragen der Datenbank verwaltet.
 * Es wird IConnection als Interfaced implementiert um die Abfragen allgemein verfügbar zu machen. 
 * TODO: Beschreibung ausbauen...
 */
package stundenplan.datenbank;

import java.sql.*;
import java.util.ArrayList;
import stundenplan.Fach;
import stundenplan.Klasse;
import stundenplan.Lehrer;

/**
 * Datenbank Klasse
 * @author fielesebastian
 */
public class Datenbank implements IConnection{
    
    private Connection verbinde;
    private Statement statement;

    /**
     * Konstruktor für die Datenbank.
     * 
     */
    public Datenbank() {
        super();
        this.verbinde = null;
        this.statement = null;
        this.oeffneVerbindung();
    }

    /**
     * Verbindung aufbauen
     * 
     */
    @Override
    public final void oeffneVerbindung() {
        try {
            // falls die Verbinung NULL oder geschlossen ist, wird sie aufgebaut
            if (this.verbinde == null || this.verbinde.isClosed()) {
                // über den DriverManager wird die Verbindung zur DB im Stammverzeichnis aufgabaut
                this.verbinde = DriverManager.getConnection("jdbc:sqlite:stundenplan.db");
                System.out.println("Datenbank gefunden.");
            }
            if (this.statement == null || this.statement.isClosed()) {
                this.statement = this.verbinde.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("Programm konnte sich nicht mit der Datenbank verbinden");
            throw new RuntimeException(e);
        }
    }

    /**
     * Verbindung wieder schliessen
     */
    @Override
    public void schliesseVerbindung() {
        try {
            if (this.statement != null) {
                    this.statement.close();
            }
            if (this.verbinde != null) {
                    this.verbinde.close();
            }
            System.out.println("Datenbank wieder geschlossen");
        } catch (SQLException e) {
            System.out.print("Datenbank konnte nicht korrekt geschlossen werden");
            throw new RuntimeException(e);
        }
    }
    
    
    /* ------------------------- Klassen ------------------------- */
    
    /**
     * Klassen aus der Datenbank auslesen
     * table Klasse: K_ID, Kuerzel
     * 
     * @return klassen
     * @throws RuntimeException when
     */
    @Override
    public ArrayList<Klasse> holeKlassen() {
        ArrayList<Klasse> klassen = new ArrayList<>();
        try (ResultSet resultSet = this.statement.executeQuery(
                "SELECT K_ID, Kuerzel FROM Klasse")) {
            // ArrayList in Objekt umwandeln
            while (resultSet.next()) {
                    klassen.add(convertRowToKlasse(resultSet));
            }
        } catch (SQLException e) {
                System.out.println("Fehler beim Auslesen der Klassen");
                throw new RuntimeException(e);
        }
        return klassen;
    }

    /**
     * Neue Klasse anlegen
     * 
     * @param klasse
     * @throws RuntimeException
     */
    @Override
    public void neueKlasse(Klasse klasse) {
        try (PreparedStatement prep = this.verbinde.prepareStatement(
                "INSERT INTO Klasse (K_ID, Kuerzel) VALUES (?, ?)")) {
            prep.setInt(1, klasse.getId());
            prep.setString(2, klasse.getName());
            
            prep.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Kann die Klasse nicht einfügen");
            throw new RuntimeException(e);
        }

    }

    /**
     * Klasse aktualisieren
     * 
     * @param title
     * @param klasse
     * @throws RuntimeException
     */
    @Override
    public void updateKlasse(String title, Klasse klasse) {
        try (PreparedStatement prep = this.verbinde.prepareStatement(
                "UPDATE Klasse SET K_ID = ?, Kuerzel = ? WHERE title = ?")) {
            prep.setInt(1, klasse.getId());
            prep.setString(2, klasse.getName());
            prep.setString(3, title);

            prep.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Kann die Klasse nicht aktualisieren");
            throw new RuntimeException(e);
        }

    }
    
    /**
     * Konvertiert TableRow zu Klasse
     * 
     * @param results
     * @return klasse
     * @throws RuntimeException 
     */
    @Override
    public Klasse convertRowToKlasse(ResultSet results) {
        try {
            int k_id = results.getInt("K_ID");
            String kuerzel = results.getString("Kuerzel");
            return new Klasse(k_id, kuerzel);
        } catch (SQLException e) {
            System.out.println("Falsche Spaltennamen beim Abfragen der Klasse");
            throw new RuntimeException(e);
        }
    }
    
    
    /* ------------------------- Lehrer ------------------------- */
    
    /**
     * Lehrer aus der Datenbank auslesen
     * tables: L_ID, Name, Kuerzel
     * 
     * @return lehrer
     * @throws RuntimeException
     */
    @Override
    public ArrayList<Lehrer> holeLehrer() {
        ArrayList<Lehrer> lehrer = new ArrayList<>();
        try (ResultSet results = this.statement.executeQuery(
                "SELECT L_ID, Name, Kuerzel FROM Lehrer")) {
            // ArrayList in Objekt umwandeln
            while (results.next()) {
                lehrer.add(convertRowToLehrer(results));
            }
        } catch (SQLException e) {
                System.out.println("Fehler beim Auslesen der Lehrer");
                throw new RuntimeException(e);
        }
        return lehrer;
    }

    /**
     * Neue Lehrer anlegen
     * 
     * @param lehrer
     * @throws RuntimeException
     */
    @Override
    public void neuerLehrer(Lehrer lehrer) {
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "INSERT INTO Lehrer (L_ID, Kuerzel, Name) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, lehrer.getId());
            preparedStatement.setString(2, lehrer.getKuerzel());
            preparedStatement.setString(3, lehrer.getName());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kann den Lehrer nicht einfügen");
            throw new RuntimeException(e);
        }
    }

    /**
     * ausgewählten Lehrer laden 
     * 
     * @param name
     * @return selectedLehrer
     * @throws RuntimeException
     */
    @Override
    public Lehrer getSelectedLehrer(String name) {
        try (PreparedStatement preparedStatement =
                     this.verbinde.prepareStatement(
                             "SELECT L_ID, Name, Kuerzel FROM Lehrer WHERE Name = ? ")) {
            preparedStatement.setString(1, name);
            ResultSet results = preparedStatement.executeQuery();
            return convertRowToLehrer(results);
        } catch (SQLException e) {
            System.out.println("Kann den gewählten Lehrer nicht finden");
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Lehrer aktualisieren 
     * 
     * @param kuerzel
     * @param lehrer
     * @throws RuntimeException
     */
    @Override
    public void updateLehrer(String kuerzel, Lehrer lehrer) {
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "UPDATE Lehrer SET L_ID = ?, Kuerzel = ?, Name = ? WHERE title = ?")) {
            preparedStatement.setInt(1, lehrer.getId());
            preparedStatement.setString(2, lehrer.getKuerzel());
            preparedStatement.setObject(3, lehrer.getName());
            preparedStatement.setString(4, kuerzel);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Kann den Lehrer nicht aktualisieren");
            throw new RuntimeException(e);
        }
    }

    /**
     * Konvertiert TableRow zu Lehrer 
     * 
     * @param results
     * @return tempLehrer
     * @throws RuntimeException
     */
    @Override
    public Lehrer convertRowToLehrer(ResultSet results) {
        try {
            int l_id = results.getInt("L_ID");
            String kuerzel = results.getString("Kuerzel");
            String name = results.getString("Name");

            return new Lehrer(l_id, name, kuerzel);
        } catch (SQLException e) {
            System.out.println("Kann den Lehrer nicht aufbauen");
            throw new RuntimeException(e);
        }
    }

/* ------------------------- Faecher ------------------------- */
    
    /**
     * Faecher aus der Datenbank auslesen
     * tables: F_ID, Name, Kuerzel
     * 
     * @return faecher
     * @throws RuntimeException
     */
    @Override
    public ArrayList<Fach> holeFaecher() {
        ArrayList<Fach> faecher = new ArrayList<>();
        try (ResultSet results = this.statement.executeQuery(
                "SELECT F_ID, Kuerzel, Name FROM Fach")) {
            // ArrayList in Objekt umwandeln
            while (results.next()) {
                    faecher.add(convertRowToFach(results));
            }
            return faecher;
        } catch (SQLException e) {
                System.out.println("Fehler beim Auslesen der Lehrer");
                throw new RuntimeException(e);
        }
    }

    
    /**
     * Neue Fach anlegen 
     * 
     * @param fach
     * @throws RuntimeException
     */
    @Override
    public void neuesFach(Fach fach) {
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "INSERT INTO Fach (F_ID, Kuerzel, Name) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, fach.getId());
            preparedStatement.setString(2, fach.getKuerzel());
            preparedStatement.setString(3, fach.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Kann den Lehrer nicht einfügen");
            throw new RuntimeException(e);
        }
    }

    /**
     * ausgewählten Fach laden
     * 
     * @param kuerzel
     * @return selectedFach
     * @throws RuntimeException
     */
    @Override
    public Fach getSelectedFach(String kuerzel) {
        try (PreparedStatement prep = this.verbinde.prepareStatement(
                "SELECT F_ID, Kuerzel, Name FROM Fach WHERE Kuerzel = ?")) {
            prep.setString(1, kuerzel);
            ResultSet results = prep.executeQuery();
            return convertRowToFach(results);

        } catch (SQLException e) {
            System.out.println("Das Fach konnte nicht gefunden werden");
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Fach aktualisieren
     * 
     * @param kuerzel
     * @param fach
     * @throws RuntimeException
     */
    @Override
    public void updateFach(String kuerzel, Fach fach) {
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "UPDATE Fach Kuerzel = ?, Name = ? WHERE F_ID = ?")) {
            preparedStatement.setString(1, fach.getKuerzel());
            preparedStatement.setObject(2, fach.getName());
            preparedStatement.setInt(3, fach.getId());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Das Fach konnte nicht aktualisiert werden");
            throw new RuntimeException(e);
        }
    }

    /**
     * Konvertiert TableRow zu Fach
     * 
     * @param results
     * @return tempFach
     * @throws RuntimeException
     */
    @Override
    public Fach convertRowToFach(ResultSet results) {
        try {
            int f_id = results.getInt("F_ID");
            String name = results.getString("Name");
            String kuerzel = results.getString("Kuerzel");

            return new Fach(f_id, name, kuerzel);

        } catch (SQLException e) {
            System.out.println("Kann das Fach nicht aufbauen");
            throw new RuntimeException(e);
        }
    }
    
}
