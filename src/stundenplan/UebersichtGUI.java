/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fielesebastian
 */
public class UebersichtGUI extends javax.swing.JFrame {
    
    // Datenbank verbinden
    private IConnection connect = null;
    // Liste der Klassen
    private List<Klasse> klassen = new ArrayList<>();
    // Liste der Lehrer
    private List<Lehrer> lehrer = new ArrayList<>();

    /**
     * Creates new form Uebersicht
     */
    public UebersichtGUI() {
        try {
            connect = DatabaseFactory.getIConnection();
            klassen = connect.holeKlasse();
            lehrer = connect.holeLehrer();
            
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
        } finally {
            if (connect != null) {
                connect.closeConnection();
            }
        }
        // GUI initialisieren
        initComponents();
        setLocationRelativeTo(this); // Zentriert das Fenster
       
        
        // Klassen Liste füllen
        KlassenListModel klassenList = new KlassenListModel(klassen);
        lst_class.setModel(klassenList);
        
        
        // Lehrer Liste füllen
        LehrerListModel lehrerList = new LehrerListModel(lehrer);
        lst_teacher.setModel(lehrerList);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_window_title = new javax.swing.JLabel();
        btn_close = new javax.swing.JButton();
        btn_class_new = new javax.swing.JButton();
        btn_teacher_new = new javax.swing.JButton();
        btn_splan_current = new javax.swing.JButton();
        btn_splan_new = new javax.swing.JButton();
        btn_splan_prev = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_teacher = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_class = new javax.swing.JList();
        btn_teacher_edit = new javax.swing.JButton();
        btn_teacher_show = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_class_edit = new javax.swing.JButton();
        btn_class_show = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btn_action_new = new javax.swing.JButton();
        btn_subject_new = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jMenuBar2 = new javax.swing.JMenuBar();
        menu_datei = new javax.swing.JMenu();
        menu_close = new javax.swing.JMenuItem();
        menu_hilfe = new javax.swing.JMenu();
        menu_ueber = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_window_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_window_title.setText("Stundenplanverwaltungsoberfläche des Ludwig-Erhard Berufkollegs Münster");

        btn_close.setText("Programm beenden");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        btn_class_new.setText("Neue Klasse anlegen");
        btn_class_new.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_class_new.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_class_new.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_class_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_class_newActionPerformed(evt);
            }
        });

        btn_teacher_new.setText("Neue Lehrer anlegen");
        btn_teacher_new.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_teacher_new.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_teacher_new.setPreferredSize(new java.awt.Dimension(180, 40));

        btn_splan_current.setText("Aktuelle Stundenpläne ansehen");
        btn_splan_current.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_splan_current.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_splan_current.setPreferredSize(new java.awt.Dimension(220, 50));

        btn_splan_new.setText("Neuen Stundenplan anlegen");
        btn_splan_new.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_splan_new.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_splan_new.setPreferredSize(new java.awt.Dimension(220, 50));

        btn_splan_prev.setText("vergangene Stundenpläne");
        btn_splan_prev.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_splan_prev.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_splan_prev.setPreferredSize(new java.awt.Dimension(220, 50));
        btn_splan_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_splan_prevActionPerformed(evt);
            }
        });

        lst_teacher.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Lehrer 1", "Lehrer 2", "Lehrer 3", "Lehrer 4", "Lehrer 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_teacher.setPreferredSize(new java.awt.Dimension(150, 50));
        lst_teacher.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_teacherValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lst_teacher);

        lst_class.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Klasse 1", "Klasse 2", "Klasse 3", "Klasse 4", "Klasse 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lst_class);

        btn_teacher_edit.setText("Lehrer bearbeiten");
        btn_teacher_edit.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_teacher_edit.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_teacher_edit.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_teacher_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_teacher_editActionPerformed(evt);
            }
        });

        btn_teacher_show.setText("Stundenplan anzeigen");
        btn_teacher_show.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_teacher_show.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_teacher_show.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_teacher_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_teacher_showActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_class_edit.setText("Klasse bearbeiten");
        btn_class_edit.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_class_edit.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_class_edit.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_class_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_class_editActionPerformed(evt);
            }
        });

        btn_class_show.setText("Stundenplan anzeigen");
        btn_class_show.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_class_show.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_class_show.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_class_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_class_showActionPerformed(evt);
            }
        });

        btn_action_new.setText("Neue Aktivität");
        btn_action_new.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_action_new.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_action_new.setPreferredSize(new java.awt.Dimension(220, 50));

        btn_subject_new.setText("Neues Fach");
        btn_subject_new.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_subject_new.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_subject_new.setPreferredSize(new java.awt.Dimension(220, 50));

        menu_datei.setText("Datei");
        menu_datei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dateiActionPerformed(evt);
            }
        });

        menu_close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menu_close.setText("Programm beenden");
        menu_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_closeActionPerformed(evt);
            }
        });
        menu_datei.add(menu_close);

        jMenuBar2.add(menu_datei);

        menu_hilfe.setText("Hilfe");

        menu_ueber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menu_ueber.setText("Über das Programm");
        menu_ueber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ueberActionPerformed(evt);
            }
        });
        menu_hilfe.add(menu_ueber);

        jMenuBar2.add(menu_hilfe);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_splan_current, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btn_splan_new, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btn_splan_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_action_new, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_subject_new, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbl_window_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_teacher_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_teacher_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_teacher_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_class_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_class_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_class_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btn_close))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_window_title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_splan_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_splan_prev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_splan_current, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_teacher_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_teacher_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_teacher_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_class_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_class_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_class_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_action_new, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_subject_new, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_close)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_class_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_class_newActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_class_newActionPerformed

    private void btn_splan_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_splan_prevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_splan_prevActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        String message = "Wollen Sie die Stundenplanverwaltungsoberfläche wirklich beenden?";
        String title = "Sind Sie sich sicher?";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
          System.exit(0);
        }
    }//GEN-LAST:event_btn_closeActionPerformed

    private void menu_ueberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ueberActionPerformed
        String message = "Die Stundenplanverwaltungsoberfläche für das Ludwig-Erhard Berufskolleg, Münster" +"\n"+
                        "Diese Software wurde während einer Gruppenarbeit erstellt" +"\n"+
                                "von Gruppe E der Klasse ITFO3 2019";
        String title = "Stundenplanverwaltungsoberfläche";
        // Info Panel
        JOptionPane.showMessageDialog(null, message, title,JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menu_ueberActionPerformed

    private void menu_dateiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_dateiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_dateiActionPerformed

    private void menu_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_closeActionPerformed
        String message = "Wollen Sie die Stundenplanverwaltungsoberfläche wirklich beenden?";
        String title = "Sind Sie sich sicher?";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
          System.exit(0);
        }
    }//GEN-LAST:event_menu_closeActionPerformed

    private void lst_teacherValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_teacherValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lst_teacherValueChanged

    private void btn_teacher_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_teacher_editActionPerformed
        String auswahl = (String) lst_teacher.getSelectedValue(); 
//        System.out.println("gewählter Lehrer:" + auswahl + " ");
        new LehrerEditGUI(auswahl).setVisible(true);
    }//GEN-LAST:event_btn_teacher_editActionPerformed

    private void btn_teacher_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_teacher_showActionPerformed
        String auswahl = (String) lst_teacher.getSelectedValue(); 
        System.out.println("L-Stundenplan für:" + auswahl + " ");
    }//GEN-LAST:event_btn_teacher_showActionPerformed

    private void btn_class_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_class_showActionPerformed
        String auswahl = (String) lst_class.getSelectedValue(); 
        System.out.println("K-Stundenplan für:" + auswahl + " ");
    }//GEN-LAST:event_btn_class_showActionPerformed

    private void btn_class_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_class_editActionPerformed
        String auswahl = (String) lst_class.getSelectedValue(); 
        System.out.println("gewählte Klasse:" + auswahl + " ");
    }//GEN-LAST:event_btn_class_editActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UebersichtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_action_new;
    private javax.swing.JButton btn_class_edit;
    private javax.swing.JButton btn_class_new;
    private javax.swing.JButton btn_class_show;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_splan_current;
    private javax.swing.JButton btn_splan_new;
    private javax.swing.JButton btn_splan_prev;
    private javax.swing.JButton btn_subject_new;
    private javax.swing.JButton btn_teacher_edit;
    private javax.swing.JButton btn_teacher_new;
    private javax.swing.JButton btn_teacher_show;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbl_window_title;
    private javax.swing.JList lst_class;
    private javax.swing.JList lst_teacher;
    private javax.swing.JMenuItem menu_close;
    private javax.swing.JMenu menu_datei;
    private javax.swing.JMenu menu_hilfe;
    private javax.swing.JMenuItem menu_ueber;
    // End of variables declaration//GEN-END:variables
}
