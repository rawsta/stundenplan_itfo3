package stundenplan;

import javax.swing.TransferHandler;
import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author hannah.elling
 */
public class AktivitaetTransferHandler extends TransferHandler{
    private String mimeType = DataFlavor.javaJVMLocalObjectMimeType + ";class=stundenplan.Aktivitaet";
    private DataFlavor aktivitaetFlavor;

    /**
     * Eine eigene Implementation der JTable, um die gerade ausgewählte, d.h. die Stunde, die zum Ablegen gewählt ist,
     * als String zurückzubekommen
     */
    private static class JTableAdapter {
        private JTable table;

        JTableAdapter(JTable table) {
            this.table = table;
        }

        /**
         * In Zukunft muss die Methode wahrscheinlich neu geschrieben werden, oder könnte auch gemeinsam mit dem Adapter
         * ganz wegfallen, da man keinen String gebrauchen kann, sondern mit den echten Klassen (Unterrichtseinheit
         * vermutlich) arbeiten muss.
         *
         * @return in Worten, welche Stunde ausgewählt wurde.
         */
        public String getStunde() {
            int row = table.getSelectedRow();
            int column = table.getSelectedColumn();

            String tag = "";
            String block = "";

            switch (row) {
                case 0: block = "erster"; break;
                case 1: block = "zweiter"; break;
                case 2: block = "dritter"; break;
            }
            switch (column) {
                case 0: tag = "Montag"; break;
                case 1: tag = "Donnerstag"; break;
            }
            return String.format("%s %s Block", tag, block);
        }
    }

    public AktivitaetTransferHandler() {
        try {
            aktivitaetFlavor = new DataFlavor(mimeType);
        } catch (ClassNotFoundException e) {

        }
    }

    // TODO den Algorithmus "anschmeißen", d.h. eine neue Regel erstellen und diese zu den anderen Regeln hinzufügen. Mit dieser Sammlung an Regeln den Algorithmus neu aktivieren.
    /**
     * Diese Methode entscheidet, was passiert, wenn ein Inhalt der einen Tabellenzelle in eine andere gezogen wird. In
     * diesem Fall wird ein Infodialog gezeigt, in dem steht, wie in Zukunft die Regel aussieht, die erstellt wird. Mit
     * dieser wird der Algorithmus neu gestartet. Außerdem wird der Zelleninhalt der gedroppten Zelle auf den der alten
     * Zelle gesetzt.
     *
     * @param comp die Tabellenkomponente:
     * @param t aktivitaet
     * @return ob es geklappt hat. Da dies durch Implementation bedingt ist, sollte dies immer true sein
     */
    @Override
    public boolean importData(JComponent comp, Transferable t) {
        if (hasAktivitaetFlavor(t.getTransferDataFlavors())) {
            try {
                Aktivitaet aktivitaet = (Aktivitaet)t.getTransferData(aktivitaetFlavor);
                int row = ((JTable)comp).getSelectedRow();
                int column = ((JTable)comp).getSelectedColumn();
                ((JTable) comp).setValueAt(aktivitaet, row, column);

                JOptionPane.showMessageDialog(null,
                        "Jetzt würde die Berechnung angeschmissen werden.\nRegel: " + aktivitaet + " möchte nach " + new JTableAdapter(((JTable)comp)).getStunde() + " umgelegt werden.\n");
                return true;
            } catch (UnsupportedFlavorException | IOException e) {
                return false;
            }
        }
        return false;
    }


    private boolean hasAktivitaetFlavor(DataFlavor[] flavors) {
        if (aktivitaetFlavor == null) {
            return false;
        }

        for (DataFlavor flavor : flavors) {
            if (aktivitaetFlavor.equals(flavor)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canImport(JComponent c, DataFlavor[] flavors) {
        return hasAktivitaetFlavor(flavors);
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        int row = ((JTable)c).getSelectedRow();
        int column = ((JTable)c).getSelectedColumn();
        return new AktivitaetTransferable((Aktivitaet) ((JTable)c).getValueAt(row, column));
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY;
    }
}
