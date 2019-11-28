/*
 * Fabrikmethode (https://de.wikipedia.org/wiki/Fabrikmethode).
 * 
 * 
 */
package stundenplan.datenbank;

import stundenplan.datenbank.Datenbank;

/**
 * Database Factory
 * @author rawsta
 */
public class DatenbankFactory {
 
    /**
     * Singleton Instanz von IConnection 
     * "static final" bezeichnet meistens Konstanten. 
     * laut Namenskonvention werden Konstanten immer groß geschrieben.
     * 
     */
    private static final IConnection SQLCON = new Datenbank();

    /**
     * gets IConnection
     * 
     * @return IConnection
     */
    public static IConnection getIConnection() {
        SQLCON.oeffneVerbindung();
        return DatenbankFactory.SQLCON;
}
    
}
