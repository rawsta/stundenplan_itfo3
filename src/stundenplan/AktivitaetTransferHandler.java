/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import javax.swing.TransferHandler;
import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.io.IOException;

/**
 *
 * @author hannah.elling
 */
public class AktivitaetTransferHandler extends TransferHandler{
    private String mimeType = DataFlavor.javaJVMLocalObjectMimeType + ";class=stundenplan.Aktivitaet";
    private DataFlavor abbildungFlavor;
    private JTextArea ausgabe;

    private static class JTableAdapter {
        private JTable table;

        JTableAdapter(JTable table) {
            this.table = table;
        }

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

    AktivitaetTransferHandler(JTextArea ausgabe) {
        try {
            abbildungFlavor = new DataFlavor(mimeType);
        } catch (ClassNotFoundException e) {

        }
        this.ausgabe = ausgabe;
    }

    @Override
    public boolean importData(JComponent comp, Transferable t) {
        if (hasAbbildungFlavor(t.getTransferDataFlavors())) {
            try {
                Aktivitaet abb = (Aktivitaet)t.getTransferData(abbildungFlavor);
                int row = ((JTable)comp).getSelectedRow();
                int column = ((JTable)comp).getSelectedColumn();
                ((JTable) comp).setValueAt(abb, row, column);



                ausgabe.append("Jetzt würde die Berechnung angeschmissen werden.\n Regel: " + abb + " möchte nach " + new JTableAdapter(((JTable)comp)).getStunde() + " umgelegt werden.\n");


                return true;
            } catch (UnsupportedFlavorException | IOException e) {
            }
        }
        return false;
    }


    private boolean hasAbbildungFlavor(DataFlavor[] flavors) {
        if (abbildungFlavor == null) {
            return false;
        }

        for (int i = 0; i < flavors.length; i++) {
            if (abbildungFlavor.equals(flavors[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canImport(JComponent c, DataFlavor[] flavors) {
        return hasAbbildungFlavor(flavors);
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
