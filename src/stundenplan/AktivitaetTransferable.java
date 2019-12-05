/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 *
 * @author hannah.elling
 */
public class AktivitaetTransferable implements Transferable{
    private Aktivitaet abbildung;
    private DataFlavor[] flavors;

    AktivitaetTransferable(Aktivitaet abb) {
        this.abbildung = abb;
        try {
            flavors = new DataFlavor[] {
                    new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=stundenplan.Aktivitaet"),
                    DataFlavor.stringFlavor
            };
        } catch (ClassNotFoundException e) {
            flavors = new DataFlavor[] {DataFlavor.stringFlavor};
        }
    }
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        for (DataFlavor dataFlavor : getTransferDataFlavors()) {
            if (dataFlavor.equals(flavor)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (isDataFlavorSupported(flavor)) {
            if (flavor == DataFlavor.stringFlavor) {
                return abbildung.toString();
            } else {
                return abbildung;
            }
        }
        throw new UnsupportedFlavorException(flavor);
    }
}
