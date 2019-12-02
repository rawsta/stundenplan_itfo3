/**
 * Mit der Fabrikmethode stehen einfach Instanzen des Datenbank Objekts zur Verfügung.
 * Fabrikmethode (https://de.wikipedia.org/wiki/Fabrikmethode).
 * 
 */
package stundenplan.datenbank;

/**
 * DatenbankFabrik
 * @author rawsta
 */
public class DatenbankFabrik {
 
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
        return DatenbankFabrik.SQLCON;
}
    
}
