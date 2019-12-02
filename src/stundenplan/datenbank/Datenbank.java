/*
 * In dieser Klasse wird die Verbindung und die Abfragen der Datenbank verwaltet.
 * Es wird IConnection als Interface implementiert um die Abfragen allgemein verfügbar zu machen. 
 * 
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
        // this.oeffneVerbindung();
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
            System.out.println(e);
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
        oeffneVerbindung();
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
        } finally {
            schliesseVerbindung();
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
        oeffneVerbindung();
        try (PreparedStatement prep = this.verbinde.prepareStatement(
                "INSERT INTO Klasse (K_ID, Kuerzel) VALUES (?, ?)")) {
            prep.setInt(1, klasse.getId());
            prep.setString(2, klasse.getName());
            
            prep.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Kann die Klasse nicht einfügen");
            throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
        }
    }
    
     /**
     * ausgewählten Klasse laden 
     * 
     * @param auswahl
     * @return selectedKlasse
     * @throws RuntimeException
     */
    @Override
    public Klasse getSelectedKlasse(String auswahl) {
        try (PreparedStatement preparedStatement =
                     this.verbinde.prepareStatement(
                             "SELECT K_ID, Kuerzel FROM Klasse WHERE Kuerzel = ? ")) {
            preparedStatement.setString(1, auswahl);
            ResultSet results = preparedStatement.executeQuery();
            return convertRowToKlasse(results);
        } catch (SQLException e) {
            System.out.println("Kann die gewählte Klsse nicht finden");
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
        oeffneVerbindung();
        try (PreparedStatement prep = this.verbinde.prepareStatement(
                "UPDATE Klasse SET K_ID = ?, Kuerzel = ? WHERE title = ?")) {
            prep.setInt(1, klasse.getId());
            prep.setString(2, klasse.getName());
            prep.setString(3, title);

            prep.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Kann die Klasse nicht aktualisieren");
            throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
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
        oeffneVerbindung();
        ArrayList<Lehrer> lehrer = new ArrayList<>();
        try (ResultSet results = this.statement.executeQuery(
                "SELECT L_ID, Name, Kuerzel, Mo_1, Mo_2, Mo_3, Do_1, Do_2, Do_3 FROM Lehrer ORDER BY Name ASC")) {
            // ArrayList in Objekt umwandeln
            while (results.next()) {
                lehrer.add(convertRowToLehrer(results));
            }
        } catch (SQLException e) {
                System.out.println("Fehler beim Auslesen der Lehrer");
                throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
        }
        return lehrer;
    }

    /**
     * Neue Lehrer anlegen
     *
     * @throws RuntimeException
     */
    @Override
    public void neuerLehrer(String kuerzel, String name, Boolean[][] verfuegbarkeit) {
        oeffneVerbindung();
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "INSERT INTO Lehrer (Kuerzel, Name, Mo_1, Mo_2, Mo_3, Do_1, Do_2, Do_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, kuerzel);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, verfuegbarkeit[0][0] ? 1 : 0);
            preparedStatement.setInt(4, verfuegbarkeit[0][1] ? 1 : 0);
            preparedStatement.setInt(5, verfuegbarkeit[0][2] ? 1 : 0);
            preparedStatement.setInt(6, verfuegbarkeit[1][0] ? 1 : 0);
            preparedStatement.setInt(7, verfuegbarkeit[1][1] ? 1 : 0);
            preparedStatement.setInt(8, verfuegbarkeit[1][2] ? 1 : 0);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kann den Lehrer nicht einfügen");
            throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
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
        oeffneVerbindung();
        try (PreparedStatement preparedStatement =
                     this.verbinde.prepareStatement(
                             "SELECT L_ID, Name, Kuerzel, Mo_1, Mo_2, Mo_3, Do_1, Do_2, Do_3 FROM Lehrer WHERE Name = ? ")) {
            preparedStatement.setString(1, name);
            ResultSet results = preparedStatement.executeQuery();
            return convertRowToLehrer(results);
        } catch (SQLException e) {
            System.out.println("Kann den gewählten Lehrer nicht finden");
            throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
        }
    }
    
    /**
     * Lehrer aktualisieren 
     *
     * @throws RuntimeException
     */
    @Override
    public void updateLehrer(int id, String kuerzel, String name, Boolean[][] verfuegbarkeit) {
        oeffneVerbindung();
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "UPDATE Lehrer SET Kuerzel = ?, Name = ?, Mo_1 = ?, Mo_2 = ?, Mo_3 = ?, Do_1 = ?, Do_2 = ?, Do_3 = ? WHERE L_ID = ?")) {
            preparedStatement.setString(1, kuerzel);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, verfuegbarkeit[0][0] ? 1 : 0);
            preparedStatement.setInt(4, verfuegbarkeit[0][1] ? 1 : 0);
            preparedStatement.setInt(5, verfuegbarkeit[0][2] ? 1 : 0);
            preparedStatement.setInt(6, verfuegbarkeit[1][0] ? 1 : 0);
            preparedStatement.setInt(7, verfuegbarkeit[1][1] ? 1 : 0);
            preparedStatement.setInt(8, verfuegbarkeit[1][2] ? 1 : 0);
            preparedStatement.setInt(9, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Kann den Lehrer nicht aktualisieren");
            throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
        }
    }
    
    @Override
    public void loescheLehrer(String name) {
        oeffneVerbindung();
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "DELETE FROM Lehrer WHERE name=?"
        )) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kann den Lehrer nicht löschen");
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
            Boolean[][] verfuegbarkeit = new Boolean[2][3];
            verfuegbarkeit[0][0] = results.getInt("Mo_1") == 1;
            verfuegbarkeit[0][1] = results.getInt("Mo_2") == 1;
            verfuegbarkeit[0][2] = results.getInt("Mo_3") == 1;
            verfuegbarkeit[1][0] = results.getInt("Do_1") == 1;
            verfuegbarkeit[1][1] = results.getInt("Do_2") == 1;
            verfuegbarkeit[1][2] = results.getInt("Do_3") == 1;
            Lehrer tempLehrer = new Lehrer(l_id, name, kuerzel);
            tempLehrer.setVerfuegbarkeit(verfuegbarkeit);
            return tempLehrer;
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
        oeffneVerbindung();
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
        } finally {
            schliesseVerbindung();
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
        oeffneVerbindung();
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "INSERT INTO Fach (F_ID, Kuerzel, Name) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, fach.getId());
            preparedStatement.setString(2, fach.getKuerzel());
            preparedStatement.setString(3, fach.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Kann den Lehrer nicht einfügen");
            throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
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
        oeffneVerbindung();
        try (PreparedStatement prep = this.verbinde.prepareStatement(
                "SELECT F_ID, Kuerzel, Name FROM Fach WHERE Kuerzel = ?")) {
            prep.setString(1, kuerzel);
            ResultSet results = prep.executeQuery();
            return convertRowToFach(results);

        } catch (SQLException e) {
            System.out.println("Das Fach konnte nicht gefunden werden");
            throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
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
        oeffneVerbindung();
        try (PreparedStatement preparedStatement = this.verbinde.prepareStatement(
                "UPDATE Fach Kuerzel = ?, Name = ? WHERE F_ID = ?")) {
            preparedStatement.setString(1, fach.getKuerzel());
            preparedStatement.setObject(2, fach.getName());
            preparedStatement.setInt(3, fach.getId());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Das Fach konnte nicht aktualisiert werden");
            throw new RuntimeException(e);
        } finally {
            schliesseVerbindung();
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
