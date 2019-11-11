package stundenplan;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatabaseConnector {

    private Connection con;
    private Statement stmt;
    private ArrayList<Object> al_name = new ArrayList<Object>();
    private int position = 0;
    
    public DatabaseConnector() {
        oeffneDB();
        holeDaten();
        schliesseDB();
        
    }

    public void oeffneDB() {

        try {
            String url = "jdbc:sqlite://stundenplan.db";
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Kann Datenbank nicht öffnen");
            throw new RuntimeException(ex);
        }
        
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("Konnte Statement nicht ausführen");
            throw new RuntimeException(ex);
        }
    }
    
    public void schliesseDB() {
        try {
            this.stmt.close();
            this.con.close();
        } catch (SQLException ex) {
            System.out.println("Konnte Datenbank nicht schliessen");
            throw new RuntimeException(ex);
        }
    }
    
    public ResultSet leseRS(String SQL) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(SQL);
        
        } catch (SQLException ex) {
            System.out.println("Konnte Daten nicht lesen");
            throw new RuntimeException(ex);
        }
        return rs;
    }
    
    public ArrayList<Object> holeDaten(){
        String sql = "SELECT * FROM ?;";
        
        oeffneDB();
        ResultSet rs = leseRS(sql);
        try {
            
        } catch (Exception ex) {
            System.out.println("Konnte Daten nicht holen");
            throw new RuntimeException(ex);
        }
        return null; // fix das
                  
    }
}


