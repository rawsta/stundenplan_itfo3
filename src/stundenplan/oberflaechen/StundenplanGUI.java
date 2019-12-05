/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan.oberflaechen;

import javafx.util.Pair;
import javax.swing.DropMode;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import stundenplan.Aktivitaet;
import stundenplan.AktivitaetTransferHandler;
import stundenplan.Fach;
import stundenplan.Klasse;
import stundenplan.Lehrer;

/**
 *
 * @author goetzemartin
 */
public class StundenplanGUI extends javax.swing.JFrame {
    
    private Aktivitaet[][] aktivitaeten;

    /**
     * Creates new form Stundenplan_anlegen
     */
    public StundenplanGUI() {
        
    }

    public StundenplanGUI(Klasse klasse) {
        init();
        lbl_besitzer.setText(klasse.getName());
    }
    
    public StundenplanGUI(Lehrer lehrer) {
        init();
        lbl_besitzer.setText(lehrer.getKuerzel());
    }
    
    private void init() {
        initComponents();
        TableModel stunden = new DefaultTableModel(3,2) {
            @Override
            public String getColumnName(int column) {
                return column == 0 ? "Montag" : column == 1 ? "Donnerstag" : "";
            }
        };
        
        aktivitaeten = new Aktivitaet[2][3];
        aktivitaeten[0][0] = new Aktivitaet(new Klasse(1000, "ITFO3"), new Pair(new Lehrer(1000, "Schwandt", "SCHW"), null), new Fach(1000, "AWE", "AWE"));
        aktivitaeten[0][1] = new Aktivitaet(new Klasse(1001, "ITFO1"), new Pair(new Lehrer(1001, "Gehrmeyer", "WGP"), null), new Fach(1001, "Wirtschafts-und Geschäftsprozesse", "WGP"));
        aktivitaeten[0][2] = new Aktivitaet(new Klasse(1002, "ITFO2"), new Pair(new Lehrer(1002, "Ossio", "OSSI"), null), new Fach(1002, "Deutsch", "D"));
        aktivitaeten[0][0] = new Aktivitaet(new Klasse(1003, "ITFU3"), new Pair(new Lehrer(1003, "Meier-Cramm", "MECR"), null), new Fach(1003, "Englisch", "E"));
        aktivitaeten[1][1] = new Aktivitaet(new Klasse(1004, "ITFU1"), new Pair(new Lehrer(1004, "Bernarnd", "BERN"), null), new Fach(1004, "Sport", "SP"));
        aktivitaeten[1][2] = new Aktivitaet(new Klasse(1005, "ITFU2"), new Pair(new Lehrer(1005, "Kalthoff", "KALT"), null), new Fach(1005, "Kryptologie", "KRYP"));
        // Eigentlich die Werte aus aktivitaeten[][]
        stunden.setValueAt(aktivitaeten[0][0], 0, 0);
        stunden.setValueAt(aktivitaeten[0][1], 0, 1);
        stunden.setValueAt(aktivitaeten[0][2], 1, 1);
        stunden.setValueAt(aktivitaeten[0][0], 1, 0);
        stunden.setValueAt(aktivitaeten[1][1], 2, 1);
        stunden.setValueAt(aktivitaeten[1][2], 2, 0);
        tbl_stundenplan.setModel(stunden);
        tbl_stundenplan.setDragEnabled(true);
        tbl_stundenplan.setDropMode(DropMode.USE_SELECTION);
        tbl_stundenplan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_stundenplan.setCellSelectionEnabled(true);
        tbl_stundenplan.setFocusable(true);

        tbl_stundenplan.setTransferHandler(new AktivitaetTransferHandler(null));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stundenplan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_montag = new javax.swing.JLabel();
        lbl_donnerstag = new javax.swing.JLabel();
        lbl_uhrzeit_eins = new javax.swing.JLabel();
        lbl_uhrzeit_zwei = new javax.swing.JLabel();
        lbl_uhrzeit_drei = new javax.swing.JLabel();
        lbl_stundenplan = new javax.swing.JLabel();
        lbl_besitzer = new javax.swing.JLabel();
        btn_speichern = new javax.swing.JButton();
        btn_abbrechen = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tbl_stundenplan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Montag", "Donnerstag"
            }
        ));
        tbl_stundenplan.setDragEnabled(true);
        tbl_stundenplan.setRowHeight(90);
        jScrollPane1.setViewportView(tbl_stundenplan);

        lbl_montag.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_montag.setText("Montag");

        lbl_donnerstag.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_donnerstag.setText("Donnerstag");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lbl_montag, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_donnerstag, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbl_montag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_donnerstag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
        );

        lbl_uhrzeit_eins.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_uhrzeit_eins.setText("17:30-19:00 Uhr");

        lbl_uhrzeit_zwei.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_uhrzeit_zwei.setText("19:00-20:30 Uhr");

        lbl_uhrzeit_drei.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_uhrzeit_drei.setText("20:30-22:00 Uhr");

        lbl_stundenplan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_stundenplan.setText("Stundenplan: ");

        lbl_besitzer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_besitzer.setText("KLASSE");

        btn_speichern.setText("Speichern");
        btn_speichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_speichernActionPerformed(evt);
            }
        });

        btn_abbrechen.setText("Abbrechen");
        btn_abbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abbrechenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_speichern, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_abbrechen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_stundenplan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_besitzer))
                            .addComponent(lbl_uhrzeit_eins)
                            .addComponent(jSeparator2)
                            .addComponent(lbl_uhrzeit_zwei)
                            .addComponent(lbl_uhrzeit_drei))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_stundenplan)
                            .addComponent(lbl_besitzer, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lbl_uhrzeit_eins)
                        .addGap(88, 88, 88)
                        .addComponent(lbl_uhrzeit_zwei)
                        .addGap(101, 101, 101)
                        .addComponent(lbl_uhrzeit_drei))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_speichern, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_abbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_speichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_speichernActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_speichernActionPerformed

    private void btn_abbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abbrechenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_abbrechenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abbrechen;
    private javax.swing.JButton btn_speichern;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_besitzer;
    private javax.swing.JLabel lbl_donnerstag;
    private javax.swing.JLabel lbl_montag;
    private javax.swing.JLabel lbl_stundenplan;
    private javax.swing.JLabel lbl_uhrzeit_drei;
    private javax.swing.JLabel lbl_uhrzeit_eins;
    private javax.swing.JLabel lbl_uhrzeit_zwei;
    private javax.swing.JTable tbl_stundenplan;
    // End of variables declaration//GEN-END:variables
}
