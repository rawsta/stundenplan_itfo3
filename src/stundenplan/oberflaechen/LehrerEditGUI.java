/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan.oberflaechen;

import javax.swing.JToggleButton;
import stundenplan.Lehrer;
import stundenplan.datenbank.DatenbankFabrik;
import stundenplan.datenbank.IConnection;

/**
 * Die LehrerEditGUI Klasse
 * Es kann das Formular jeweils mit oder ohne ausgewähltem Lehrer aufgerufen werden.
 * @author fielesebastian
 */
public class LehrerEditGUI extends javax.swing.JFrame {
    
    // Datenbank verbinden
    private IConnection verbinde = null;
    private Lehrer lehrer;

    /**
     * Neue LehrerEditGUI laden
     */
    public LehrerEditGUI() {
        init();
        // Fensterüberschrift neu setzen
        lbl_lehrer_ueberschrift.setText("Lehrer anlegen");
    }
    
    /**
     * LehrerEditGUI mit dem ausgewähltem Lehrer laden
     * 
     * @param auswahl 
     */
    public LehrerEditGUI(String auswahl) {
        init();
        
        // Datenbank nach dem ausgewählten Lehrer abfragen
        try {
            lehrer = verbinde.getSelectedLehrer(auswahl);

            // Textfelder mit gelesenen Daten befüllen
            txt_lehrer_name.setText(lehrer.getName());
            txt_lehrer_kuerzel.setText(lehrer.getKuerzel());
            tgl_mo_1.setSelected(!lehrer.getVerfuegbarkeit()[0][0]);
            tgl_mo_2.setSelected(!lehrer.getVerfuegbarkeit()[0][1]);
            tgl_mo_3.setSelected(!lehrer.getVerfuegbarkeit()[0][2]);
            tgl_do_1.setSelected(!lehrer.getVerfuegbarkeit()[1][0]);
            tgl_do_2.setSelected(!lehrer.getVerfuegbarkeit()[1][1]);
            tgl_do_3.setSelected(!lehrer.getVerfuegbarkeit()[1][2]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void init() {
        initComponents();
        // Zentriert das Fenster
        setLocationRelativeTo(this);
        // Fenster auf definierte Größe setzen
        this.setSize(418, 350);
        this.verbinde = DatenbankFabrik.getIConnection();
    }
    
    private void toggleVerfuegbarButton(JToggleButton button) {
        // Wenn ausgewählt, wird die Beschriftung ersetzt
        button.setText(button.isSelected() ? "BELEGT" : "Verfügbar");
    }

    private void setFaecher() {
        // muss noch, je nachdem wie die Faecher angegeben / ausgewählt werden
    }

    private void setVerfuegbarkeit() {
        lehrer.setVerfuegbarkeit(getVerfuegbarkeit());
    }

    private Boolean[][] getVerfuegbarkeit() {
        Boolean[][] verfuegbarkeit = new Boolean[2][3];
        verfuegbarkeit[0][0] = !tgl_mo_1.isSelected();
        verfuegbarkeit[0][1] = !tgl_mo_2.isSelected();
        verfuegbarkeit[0][2] = !tgl_mo_3.isSelected();
        verfuegbarkeit[1][0] = !tgl_do_1.isSelected();
        verfuegbarkeit[1][1] = !tgl_do_2.isSelected();
        verfuegbarkeit[1][2] = !tgl_do_3.isSelected();
        return verfuegbarkeit;
    }

     private String getLehrerKuerzel() {
        return txt_lehrer_kuerzel.getText();
     }

     private String getLehrerName() {
        return txt_lehrer_name.getText();
     }

    private void setLehrerKuerzel() {
        lehrer.setKuerzel(txt_lehrer_kuerzel.getText());
    }

    private void setLehrerName() {
        lehrer.setName(txt_lehrer_name.getText());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_lehrer_ueberschrift = new javax.swing.JLabel();
        lbl_lehrer_edit_name = new javax.swing.JLabel();
        txt_lehrer_name = new javax.swing.JTextField();
        txt_lehrer_kuerzel = new javax.swing.JTextField();
        lbl_lehrer_edit_short = new javax.swing.JLabel();
        btn_lehrer_abbrechen = new javax.swing.JButton();
        btn_lehrer_speichern = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_lehrer_faecher = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        tgl_mo_1 = new javax.swing.JToggleButton();
        lbl_verfuegbarkeit = new javax.swing.JLabel();
        lbl_montag = new javax.swing.JLabel();
        lbl_donnerstag = new javax.swing.JLabel();
        tgl_mo_2 = new javax.swing.JToggleButton();
        tgl_mo_3 = new javax.swing.JToggleButton();
        tgl_do_1 = new javax.swing.JToggleButton();
        tgl_do_2 = new javax.swing.JToggleButton();
        tgl_do_3 = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lehrer bearbeiten");
        setPreferredSize(new java.awt.Dimension(410, 310));

        lbl_lehrer_ueberschrift.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_lehrer_ueberschrift.setText("Lehrer bearbeiten");

        lbl_lehrer_edit_name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_lehrer_edit_name.setText("Name");

        txt_lehrer_name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_lehrer_name.setPreferredSize(new java.awt.Dimension(90, 30));

        txt_lehrer_kuerzel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_lehrer_kuerzel.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_lehrer_edit_short.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_lehrer_edit_short.setText("Kürzel");

        btn_lehrer_abbrechen.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_lehrer_abbrechen.setText("Abbrechen");
        btn_lehrer_abbrechen.setMaximumSize(new java.awt.Dimension(80, 30));
        btn_lehrer_abbrechen.setMinimumSize(new java.awt.Dimension(80, 30));
        btn_lehrer_abbrechen.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_lehrer_abbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lehrer_abbrechenActionPerformed(evt);
            }
        });

        btn_lehrer_speichern.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_lehrer_speichern.setText("Speichern");
        btn_lehrer_speichern.setMaximumSize(new java.awt.Dimension(90, 30));
        btn_lehrer_speichern.setMinimumSize(new java.awt.Dimension(90, 30));
        btn_lehrer_speichern.setPreferredSize(new java.awt.Dimension(90, 30));
        btn_lehrer_speichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lehrer_speichernActionPerformed(evt);
            }
        });

        lst_lehrer_faecher.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(lst_lehrer_faecher);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Fächer");

        tgl_mo_1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tgl_mo_1.setText("Verfügbar");
        tgl_mo_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tgl_mo_1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tgl_mo_1ItemStateChanged(evt);
            }
        });
        tgl_mo_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_mo_1ActionPerformed(evt);
            }
        });

        lbl_verfuegbarkeit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_verfuegbarkeit.setText("Verfügbarkeit");

        lbl_montag.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_montag.setText("Montag");

        lbl_donnerstag.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_donnerstag.setText("Donnerstag");

        tgl_mo_2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tgl_mo_2.setText("Verfügbar");
        tgl_mo_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tgl_mo_2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tgl_mo_2ItemStateChanged(evt);
            }
        });

        tgl_mo_3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tgl_mo_3.setText("Verfügbar");
        tgl_mo_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tgl_mo_3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tgl_mo_3ItemStateChanged(evt);
            }
        });

        tgl_do_1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tgl_do_1.setText("Verfügbar");
        tgl_do_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tgl_do_1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tgl_do_1ItemStateChanged(evt);
            }
        });

        tgl_do_2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tgl_do_2.setText("Verfügbar");
        tgl_do_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tgl_do_2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tgl_do_2ItemStateChanged(evt);
            }
        });

        tgl_do_3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tgl_do_3.setText("Verfügbar");
        tgl_do_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tgl_do_3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tgl_do_3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_lehrer_abbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_lehrer_speichern, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_lehrer_edit_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_lehrer_edit_short, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_lehrer_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_lehrer_kuerzel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_lehrer_ueberschrift)
                            .addComponent(lbl_verfuegbarkeit)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_donnerstag)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_montag)
                                        .addGap(21, 21, 21)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tgl_do_1)
                                    .addComponent(tgl_mo_1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tgl_do_2)
                                    .addComponent(tgl_mo_2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tgl_do_3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tgl_mo_3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_lehrer_ueberschrift)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_lehrer_edit_name)
                            .addComponent(txt_lehrer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_lehrer_edit_short)
                            .addComponent(txt_lehrer_kuerzel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_verfuegbarkeit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tgl_mo_1)
                    .addComponent(tgl_mo_2)
                    .addComponent(tgl_mo_3)
                    .addComponent(lbl_montag))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbl_donnerstag)
                    .addComponent(tgl_do_1)
                    .addComponent(tgl_do_2)
                    .addComponent(tgl_do_3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_lehrer_abbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lehrer_speichern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tgl_mo_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_mo_1ItemStateChanged
        toggleVerfuegbarButton(tgl_mo_1);
    }//GEN-LAST:event_tgl_mo_1ItemStateChanged

    private void tgl_mo_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_mo_2ItemStateChanged
        toggleVerfuegbarButton(tgl_mo_2);
    }//GEN-LAST:event_tgl_mo_2ItemStateChanged

    private void tgl_mo_3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_mo_3ItemStateChanged
        toggleVerfuegbarButton(tgl_mo_3);
    }//GEN-LAST:event_tgl_mo_3ItemStateChanged

    private void tgl_do_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_do_1ItemStateChanged
        toggleVerfuegbarButton(tgl_do_1);
    }//GEN-LAST:event_tgl_do_1ItemStateChanged

    private void tgl_do_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_do_2ItemStateChanged
        toggleVerfuegbarButton(tgl_do_2);
    }//GEN-LAST:event_tgl_do_2ItemStateChanged

    private void tgl_do_3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_do_3ItemStateChanged
        toggleVerfuegbarButton(tgl_do_3); 
    }//GEN-LAST:event_tgl_do_3ItemStateChanged

    private void tgl_mo_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_mo_1ActionPerformed
        // TODO Evtl die Verfügbarkeit in einem mehrdimensionalem Array speichern und für die verfügbarkeit in den Blöcken die jeweillige position nehmen
    }//GEN-LAST:event_tgl_mo_1ActionPerformed

    private void btn_lehrer_abbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lehrer_abbrechenActionPerformed
        // Fenster schliessen
        this.setVisible(false);
    }//GEN-LAST:event_btn_lehrer_abbrechenActionPerformed

    private void btn_lehrer_speichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lehrer_speichernActionPerformed
        if (lehrer != null) {
            verbinde.oeffneVerbindung();
            this.verbinde.updateLehrer(lehrer.getId(), getLehrerKuerzel(), getLehrerName(), getVerfuegbarkeit());
        } else {
            this.verbinde.neuerLehrer(getLehrerKuerzel(), getLehrerName(), getVerfuegbarkeit());
        }
        this.setVisible(false);
    }//GEN-LAST:event_btn_lehrer_speichernActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lehrer_abbrechen;
    private javax.swing.JButton btn_lehrer_speichern;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_donnerstag;
    private javax.swing.JLabel lbl_lehrer_edit_name;
    private javax.swing.JLabel lbl_lehrer_edit_short;
    private javax.swing.JLabel lbl_lehrer_ueberschrift;
    private javax.swing.JLabel lbl_montag;
    private javax.swing.JLabel lbl_verfuegbarkeit;
    private javax.swing.JList<String> lst_lehrer_faecher;
    private javax.swing.JToggleButton tgl_do_1;
    private javax.swing.JToggleButton tgl_do_2;
    private javax.swing.JToggleButton tgl_do_3;
    private javax.swing.JToggleButton tgl_mo_1;
    private javax.swing.JToggleButton tgl_mo_2;
    private javax.swing.JToggleButton tgl_mo_3;
    private javax.swing.JTextField txt_lehrer_kuerzel;
    private javax.swing.JTextField txt_lehrer_name;
    // End of variables declaration//GEN-END:variables
}
