/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan.oberflaechen;

import stundenplan.Fach;
import stundenplan.datenbank.IConnection;
import stundenplan.datenbank.DatenbankFabrik;

/**
 * Die FachEditGUI Klasse
 * Es kann das Formular jeweils mit oder ohne ausgewähltem Lehrer aufgerufen werden.
 * @author fielesebastian
 */
public class FachEditGUI extends javax.swing.JFrame {
    
    // Datenbank verbinden
    private IConnection verbinde = null;
    private Fach fach;

    /**
     * Neue FachEditGUI laden
     */
    public FachEditGUI() {
        init();
        // Fensterüberschrift neu setzen
        lbl_klasse_ueberschrift.setText("Fach anlegen");
    }
    
    /**
     * FachEditGUI mit dem ausgewähltem Fach laden
     * 
     * @param name
     */
    public FachEditGUI(String name) {
        init();
        
        // Datenbank nach dem ausgewählten Fach abfragen
        try {
            verbinde = DatenbankFabrik.getIConnection();
            fach = verbinde.getSelectedFach(name);
            // Kürzel und Name des Fachs auslesen
            String fach_name = fach.getName();
            String fach_kuerzel = fach.getName();

            txt_fach_name.setText(fach_name);
            txt_fach_kuerzel.setText(fach_kuerzel);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (verbinde != null) {
                verbinde.schliesseVerbindung();
            }
        }
    }
    
    private void init() {
        initComponents();
        // Zentriert das Fenster
        setLocationRelativeTo(this);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_klasse_ueberschrift = new javax.swing.JLabel();
        txt_fach_kuerzel = new javax.swing.JTextField();
        lbl_fach_edit_kuerzel = new javax.swing.JLabel();
        btn_fach_abbrechen = new javax.swing.JButton();
        btn_fach_speichern = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_fach_edit_name = new javax.swing.JLabel();
        txt_fach_name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Klasse bearbeiten");

        lbl_klasse_ueberschrift.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_klasse_ueberschrift.setText("Fach bearbeiten");

        txt_fach_kuerzel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_fach_kuerzel.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_fach_edit_kuerzel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_fach_edit_kuerzel.setText("Kürzel");

        btn_fach_abbrechen.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_fach_abbrechen.setText("Abbrechen");
        btn_fach_abbrechen.setMaximumSize(new java.awt.Dimension(80, 30));
        btn_fach_abbrechen.setMinimumSize(new java.awt.Dimension(80, 30));
        btn_fach_abbrechen.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_fach_abbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fach_abbrechenActionPerformed(evt);
            }
        });

        btn_fach_speichern.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_fach_speichern.setText("Speichern");
        btn_fach_speichern.setMaximumSize(new java.awt.Dimension(90, 30));
        btn_fach_speichern.setMinimumSize(new java.awt.Dimension(90, 30));
        btn_fach_speichern.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_fach_edit_name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_fach_edit_name.setText("Name");

        txt_fach_name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_fach_name.setPreferredSize(new java.awt.Dimension(90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_fach_abbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_fach_speichern, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_klasse_ueberschrift)
                                    .addGap(94, 94, 94))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_fach_edit_kuerzel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_fach_kuerzel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_fach_edit_name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_fach_name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_klasse_ueberschrift)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fach_edit_name)
                    .addComponent(txt_fach_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fach_edit_kuerzel)
                    .addComponent(txt_fach_kuerzel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_fach_abbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_fach_speichern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_fach_abbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fach_abbrechenActionPerformed
        // Fenster schliessen
        this.setVisible(false);
    }//GEN-LAST:event_btn_fach_abbrechenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_fach_abbrechen;
    private javax.swing.JButton btn_fach_speichern;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_fach_edit_kuerzel;
    private javax.swing.JLabel lbl_fach_edit_name;
    private javax.swing.JLabel lbl_klasse_ueberschrift;
    private javax.swing.JTextField txt_fach_kuerzel;
    private javax.swing.JTextField txt_fach_name;
    // End of variables declaration//GEN-END:variables
}
