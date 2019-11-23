/*
 * Fabrikmethode (https://de.wikipedia.org/wiki/Fabrikmethode).
 * 
 * 
 */
package stundenplan;

/**
 * Database Factory
 * @author rawsta
 */
public class DatabaseFactory {
 
    /**
     * Singleton Instanz von IConnection 
     * "static final" bezeichnet meistens Konstanten. 
     * laut Namenskonvention werden Konstanten immer groß geschrieben.
     * 
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
