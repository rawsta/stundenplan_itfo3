package stundenplan;

import java.sql.*;
import java.util.ArrayList;

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
        } catch (Exception ex) {
            //TODO Fehlermeldung PopUp
        }
        
        try {
            stmt = con.createStatement();
        } catch (Exception ex) {
            //TODO Fehlermeldung PopUp
        }
    }
    
    public void schliesseDB() {
        try {
            this.stmt.close();
            this.con.close();
        } catch (SQLException ex) {
            //TODO Fehlermeldung PopUp
        }
    }
    
    public ResultSet leseRS(String SQL) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(SQL);
        
        } catch (SQLException ex) {
            //TODO Fehlermeldung PopUp
        }
        return rs;
    }
    
    public ArrayList<Object> holeDaten(){
        String sql = "SELECT * FROM ?;";
        
        oeffneDB();
        ResultSet rs = leseRS(sql);
        try {
            
        }
                  
    }
}


