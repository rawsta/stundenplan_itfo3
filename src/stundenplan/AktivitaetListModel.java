package stundenplan;

import javax.swing.AbstractListModel;
import java.util.ArrayList;
import java.util.List;

public class AktivitaetListModel extends AbstractListModel {
    /* Daten für das ListModel */
    private List<Aktivitaet> aktivitaeten = new ArrayList<>();

    /**
     * Konstruktor für Fächer
     *
     * @param aktivitaeten
     */
    public AktivitaetListModel(List<Aktivitaet> aktivitaeten) {
        this.aktivitaeten = aktivitaeten;
    }

    /**
     * Größe der Fächerliste ausgeben
     *
     * @return
     */
    @Override
    public int getSize() {
        return aktivitaeten.size();
    }

    /**
     * Element an Index finden
     *
     * @param index
     * @return
     */
    @Override
    public Object getElementAt(int index) {
        return index >= aktivitaeten.size() ? null : aktivitaeten.get(index);
    }
}
