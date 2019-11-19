/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

/**
 *
 * @author rawsta
 */
public class LehrerEditGUI extends javax.swing.JFrame {
    
    // Datenbank verbinden
    private IConnection connect = null;

    /**
     * Creates new form LehrerEdit
     */
    public LehrerEditGUI() {
        initComponents();
        setLocationRelativeTo(this); // Zentriert das Fenster
    }
    
    
    public LehrerEditGUI(String auswahl) {
        
        Lehrer tempLehrer = null;
        
        try {
            connect = DatabaseFactory.getIConnection();
            tempLehrer = connect.getSelectedLehrer(auswahl);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connect != null) {
                connect.closeConnection();
            }
        }
        initComponents();
        setLocationRelativeTo(this); // Zentriert das Fenster
        
        String l_name = tempLehrer.getName();
        String l_short = tempLehrer.getKuerzel();
                
        txt_teacher_name.setText(l_name);
        txt_teacher_short.setText(l_short);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_teacher_edit = new javax.swing.JLabel();
        lbl_lehrer_edit_name = new javax.swing.JLabel();
        txt_teacher_name = new javax.swing.JTextField();
        txt_teacher_short = new javax.swing.JTextField();
        lbl_lehrer_edit_short = new javax.swing.JLabel();
        btn_teacher_save = new javax.swing.JButton();
        btn_teacher_save1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
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

        lbl_teacher_edit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_teacher_edit.setText("Lehrer bearbeiten");

        lbl_lehrer_edit_name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_lehrer_edit_name.setText("Name");

        txt_teacher_name.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_teacher_name.setPreferredSize(new java.awt.Dimension(90, 30));

        txt_teacher_short.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_teacher_short.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_lehrer_edit_short.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_lehrer_edit_short.setText("Kürzel");

        btn_teacher_save.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_teacher_save.setText("Abbrechen");
        btn_teacher_save.setMaximumSize(new java.awt.Dimension(80, 30));
        btn_teacher_save.setMinimumSize(new java.awt.Dimension(80, 30));
        btn_teacher_save.setPreferredSize(new java.awt.Dimension(80, 30));

        btn_teacher_save1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_teacher_save1.setText("Speichern");
        btn_teacher_save1.setMaximumSize(new java.awt.Dimension(90, 30));
        btn_teacher_save1.setMinimumSize(new java.awt.Dimension(90, 30));
        btn_teacher_save1.setPreferredSize(new java.awt.Dimension(90, 30));

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Fach 1", "Fach 2", "Fach 3", "Fach 4", "Fach 5", "Fach 6" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                            .addComponent(tgl_mo_3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_teacher_save, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_teacher_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_teacher_edit)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_lehrer_edit_name, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_lehrer_edit_short, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_teacher_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_teacher_short, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_verfuegbarkeit))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_teacher_edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_lehrer_edit_name)
                            .addComponent(txt_teacher_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_lehrer_edit_short)
                            .addComponent(txt_teacher_short, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btn_teacher_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_teacher_save1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tgl_mo_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_mo_1ItemStateChanged
        if (tgl_mo_1.isSelected()) 
            tgl_mo_1.setText("BELEGT");  
        else  
            tgl_mo_1.setText("Verfügbar");  
    }//GEN-LAST:event_tgl_mo_1ItemStateChanged

    private void tgl_mo_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_mo_2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_mo_2ItemStateChanged

    private void tgl_mo_3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_mo_3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_mo_3ItemStateChanged

    private void tgl_do_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_do_1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_do_1ItemStateChanged

    private void tgl_do_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_do_2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_do_2ItemStateChanged

    private void tgl_do_3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgl_do_3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_do_3ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_teacher_save;
    private javax.swing.JButton btn_teacher_save1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_donnerstag;
    private javax.swing.JLabel lbl_lehrer_edit_name;
    private javax.swing.JLabel lbl_lehrer_edit_short;
    private javax.swing.JLabel lbl_montag;
    private javax.swing.JLabel lbl_teacher_edit;
    private javax.swing.JLabel lbl_verfuegbarkeit;
    private javax.swing.JToggleButton tgl_do_1;
    private javax.swing.JToggleButton tgl_do_2;
    private javax.swing.JToggleButton tgl_do_3;
    private javax.swing.JToggleButton tgl_mo_1;
    private javax.swing.JToggleButton tgl_mo_2;
    private javax.swing.JToggleButton tgl_mo_3;
    private javax.swing.JTextField txt_teacher_name;
    private javax.swing.JTextField txt_teacher_short;
    // End of variables declaration//GEN-END:variables
}
