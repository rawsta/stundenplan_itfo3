/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

/**
 *
 * @author rawsta
 */
public class DatabaseFactory {
 
    /**
     * singleton instance of IConnection 
     * static final -> constants (uppercase)
     */
    private static final IConnection SQLCON = new Database();

    /**
     * gets IConnection
     * 
     * @return IConnection
     */
    public static IConnection getIConnection() {
        SQLCON.openConnection();
        return DatabaseFactory.SQLCON;
}
    
}
