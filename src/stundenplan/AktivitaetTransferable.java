package stundenplan;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 * Mit dieser Klasse wird sichergestellt, dass in der Tabelle nicht Strings, sondern quasi die Klasse Aktivitaet
 * gespeichert wird. In der Oberfläche wird natürlich die Rückgabe der toString()-Methode der Klasse angezeigt. Dies
 * bietet den Vorteil, auch intern (Algorithmus, Regeln, Prioritäten) mit Objekten arbeiten zu können und nicht mit
 * Strings.
 *
 * @author hannah.elling
 */
public class AktivitaetTransferable implements Transferable{
    private Aktivitaet aktivitaet;
    private DataFlavor[] flavors;

    AktivitaetTransferable(Aktivitaet aktivitaet) {
        this.aktivitaet = aktivitaet;
        try {
            flavors = new DataFlavor[] {
                    new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=stundenplan.Aktivitaet"),
            };
        } catch (ClassNotFoundException e) {
            flavors = new DataFlavor[] {};
        }
    }
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        for (DataFlavor dataFlavor : getTransferDataFlavors()) {
            if (dataFlavor.equals(flavor)) return true;
        }
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (isDataFlavorSupported(flavor)) return aktivitaet;
        throw new UnsupportedFlavorException(flavor);
    }
}
