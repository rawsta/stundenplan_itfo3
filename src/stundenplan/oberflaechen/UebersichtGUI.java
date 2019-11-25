/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan.oberflaechen;

import stundenplan.oberflaechen.LehrerEditGUI;
import stundenplan.datenbank.IConnection;
import stundenplan.datenbank.DatenbankFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import stundenplan.Fach;
import stundenplan.FachListModel;
import stundenplan.Klasse;
import stundenplan.KlassenListModel;
import stundenplan.Lehrer;
import stundenplan.LehrerListModel;

/**
 * Die zentrale GUI von der alle Interaktion ausgeht. 
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
    // Liste der Fächer
    private List<Fach> faecher = new ArrayList<>();

    /**
     * Hier werden die Daten geholt und die eigentliche GUI aufgebaut.
     */
    public UebersichtGUI() {
        try {
            connect = DatenbankFactory.getIConnection();
            klassen = connect.holeKlasse();
            lehrer = connect.holeLehrer();
            faecher = connect.holeFach();
            
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
        
        // Fächer Liste füllen
        FachListModel faecherList = new FachListModel(faecher);
        lst_faecher.setModel(faecherList);
        
        
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
        jSeparator6 = new javax.swing.JSeparator();
        tab_sections = new javax.swing.JTabbedPane();
        tab_teacher = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_teacher = new javax.swing.JList();
        btn_teacher_show = new javax.swing.JButton();
        btn_teacher_edit = new javax.swing.JButton();
        btn_teacher_new = new javax.swing.JButton();
        tab_classes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_class = new javax.swing.JList();
        btn_class_show = new javax.swing.JButton();
        btn_class_edit = new javax.swing.JButton();
        btn_class_new = new javax.swing.JButton();
        tab_subjects = new javax.swing.JPanel();
        btn_fach_new = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lst_faecher = new javax.swing.JList();
        btn_fach_edit = new javax.swing.JButton();
        Activities = new javax.swing.JPanel();
        btn_action_new = new javax.swing.JButton();
        btn_action_reset = new javax.swing.JButton();
        tab_splan = new javax.swing.JPanel();
        btn_splan_current = new javax.swing.JButton();
        btn_splan_new = new javax.swing.JButton();
        btn_splan_prev = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jMenuBar2 = new javax.swing.JMenuBar();
        menu_datei = new javax.swing.JMenu();
        menu_close = new javax.swing.JMenuItem();
        menu_hilfe = new javax.swing.JMenu();
        menu_ueber = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_window_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_window_title.setText("Stundenplanverwaltungsoberfläche des Ludwig-Erhard Berufkollegs Münster");

        btn_close.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_close.setText("Programm beenden");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        tab_sections.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lst_teacher.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lst_teacher.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Lehrer 1", "Lehrer 2", "Lehrer 3", "Lehrer 4", "Lehrer 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_teacher.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lst_teacher.setMaximumSize(new java.awt.Dimension(43, 90));
        lst_teacher.setMinimumSize(new java.awt.Dimension(43, 90));
        lst_teacher.setPreferredSize(new java.awt.Dimension(43, 90));
        lst_teacher.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_teacherValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lst_teacher);

        btn_teacher_show.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_teacher_show.setText("Stundenplan anzeigen");
        btn_teacher_show.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_teacher_show.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_teacher_show.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_teacher_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_teacher_showActionPerformed(evt);
            }
        });

        btn_teacher_edit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_teacher_edit.setText("Lehrer bearbeiten");
        btn_teacher_edit.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_teacher_edit.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_teacher_edit.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_teacher_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_teacher_editActionPerformed(evt);
            }
        });

        btn_teacher_new.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_teacher_new.setText("Neue Lehrer anlegen");
        btn_teacher_new.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_teacher_new.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_teacher_new.setPreferredSize(new java.awt.Dimension(180, 40));

        javax.swing.GroupLayout tab_teacherLayout = new javax.swing.GroupLayout(tab_teacher);
        tab_teacher.setLayout(tab_teacherLayout);
        tab_teacherLayout.setHorizontalGroup(
            tab_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_teacherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_teacher_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_teacher_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_teacher_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        tab_teacherLayout.setVerticalGroup(
            tab_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_teacherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_teacherLayout.createSequentialGroup()
                        .addComponent(btn_teacher_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_teacher_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_teacher_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab_sections.addTab("Lehrer", tab_teacher);

        lst_class.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lst_class.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Klasse 1", "Klasse 2", "Klasse 3", "Klasse 4", "Klasse 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_class.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lst_class);

        btn_class_show.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_class_show.setText("Stundenplan anzeigen");
        btn_class_show.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_class_show.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_class_show.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_class_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_class_showActionPerformed(evt);
            }
        });

        btn_class_edit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_class_edit.setText("Klasse bearbeiten");
        btn_class_edit.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_class_edit.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_class_edit.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_class_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_class_editActionPerformed(evt);
            }
        });

        btn_class_new.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_class_new.setText("Neue Klasse anlegen");
        btn_class_new.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_class_new.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_class_new.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_class_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_class_newActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab_classesLayout = new javax.swing.GroupLayout(tab_classes);
        tab_classes.setLayout(tab_classesLayout);
        tab_classesLayout.setHorizontalGroup(
            tab_classesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_classesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_classesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_class_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_class_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_class_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        tab_classesLayout.setVerticalGroup(
            tab_classesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_classesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_classesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_classesLayout.createSequentialGroup()
                        .addComponent(btn_class_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_class_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_class_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab_sections.addTab("Klassen", tab_classes);

        btn_fach_new.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_fach_new.setText("Neues Fach");
        btn_fach_new.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_fach_new.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_fach_new.setPreferredSize(new java.awt.Dimension(180, 40));

        lst_faecher.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lst_faecher.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Fach 1", "Fach 2", "Fach 3", "Fach 4", "Fach 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_faecher.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lst_faecher.setMaximumSize(new java.awt.Dimension(150, 50));
        lst_faecher.setMinimumSize(new java.awt.Dimension(150, 50));
        lst_faecher.setPreferredSize(new java.awt.Dimension(150, 50));
        lst_faecher.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_faecherValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lst_faecher);
        lst_faecher.getAccessibleContext().setAccessibleName("Liste Fächer");

        btn_fach_edit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_fach_edit.setText("Fach bearbeiten");
        btn_fach_edit.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_fach_edit.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_fach_edit.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_fach_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fach_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab_subjectsLayout = new javax.swing.GroupLayout(tab_subjects);
        tab_subjects.setLayout(tab_subjectsLayout);
        tab_subjectsLayout.setHorizontalGroup(
            tab_subjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_subjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_subjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_fach_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_fach_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(321, Short.MAX_VALUE))
        );
        tab_subjectsLayout.setVerticalGroup(
            tab_subjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_subjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_subjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addGroup(tab_subjectsLayout.createSequentialGroup()
                        .addComponent(btn_fach_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btn_fach_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tab_sections.addTab("Fächer", tab_subjects);

        btn_action_new.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_action_new.setText("Neue Aktivität");
        btn_action_new.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_action_new.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_action_new.setPreferredSize(new java.awt.Dimension(220, 50));

        btn_action_reset.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_action_reset.setText("Aktivitäten zurücksetzen");
        btn_action_reset.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_action_reset.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_action_reset.setPreferredSize(new java.awt.Dimension(220, 50));

        javax.swing.GroupLayout ActivitiesLayout = new javax.swing.GroupLayout(Activities);
        Activities.setLayout(ActivitiesLayout);
        ActivitiesLayout.setHorizontalGroup(
            ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActivitiesLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btn_action_new, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_action_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        ActivitiesLayout.setVerticalGroup(
            ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActivitiesLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_action_new, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_action_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        tab_sections.addTab("Aktivitäten", Activities);

        btn_splan_current.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_splan_current.setText("Aktuelle Stundenpläne ansehen");
        btn_splan_current.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_splan_current.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_splan_current.setPreferredSize(new java.awt.Dimension(220, 50));

        btn_splan_new.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_splan_new.setText("Neuen Stundenplan anlegen");
        btn_splan_new.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_splan_new.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_splan_new.setPreferredSize(new java.awt.Dimension(220, 50));

        btn_splan_prev.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_splan_prev.setText("Stundenplan ansehen");
        btn_splan_prev.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_splan_prev.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_splan_prev.setPreferredSize(new java.awt.Dimension(220, 50));
        btn_splan_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_splan_prevActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Stundenplan 1", "Stundenplan 2", "Stundenplan 3", "Stundenplan 4", "Stundenplan 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jList1);

        javax.swing.GroupLayout tab_splanLayout = new javax.swing.GroupLayout(tab_splan);
        tab_splan.setLayout(tab_splanLayout);
        tab_splanLayout.setHorizontalGroup(
            tab_splanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(tab_splanLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(tab_splanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_splan_current, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_splan_new, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addGroup(tab_splanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(btn_splan_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        tab_splanLayout.setVerticalGroup(
            tab_splanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_splanLayout.createSequentialGroup()
                .addGroup(tab_splanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_splanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(tab_splanLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btn_splan_current, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_splan_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btn_splan_prev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab_sections.addTab("Stundenpläne", tab_splan);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_close)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_window_title, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tab_sections, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_window_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab_sections, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        String message = "Die Stundenplanverwaltungsoberfläche für das Ludwig-Erhard Berufskolleg, Münster" +"\n\n"+
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
        /* Strings für die Meldung befüllen */
        String message = "Wollen Sie die Stundenplanverwaltungsoberfläche wirklich beenden?";
        String title = "Sind Sie sich sicher?";
        /* Schließen Disalog aufrufen und Antwort verarbeiten */
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
          System.exit(0);
        }
    }//GEN-LAST:event_menu_closeActionPerformed

    private void lst_teacherValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_teacherValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lst_teacherValueChanged

    private void btn_teacher_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_teacher_editActionPerformed
        /* Gewählten Lehrer aus der Liste herausfinden */
        String auswahl = (String) lst_teacher.getSelectedValue(); 
//        System.out.println("gewählter Lehrer:" + auswahl + " ");
        /* Neue GUI mit dem ausgewählten Lehrer aufrufen */
        new LehrerEditGUI(auswahl).setVisible(true);
    }//GEN-LAST:event_btn_teacher_editActionPerformed

    private void btn_teacher_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_teacher_showActionPerformed
        /* Gewählten Lehrer aus der Liste herausfinden */
        String auswahl = (String) lst_teacher.getSelectedValue(); 
        System.out.println("L-Stundenplan für:" + auswahl + " ");
    }//GEN-LAST:event_btn_teacher_showActionPerformed

    private void btn_class_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_class_showActionPerformed
        /* Gewählte Klasse aus der Liste herausfinden */
        String auswahl = (String) lst_class.getSelectedValue(); 
        System.out.println("K-Stundenplan für:" + auswahl + " ");
    }//GEN-LAST:event_btn_class_showActionPerformed

    private void btn_class_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_class_editActionPerformed
        /* Gewählte Klasse aus der Liste herausfinden */
        String auswahl = (String) lst_class.getSelectedValue(); 
        System.out.println("gewählte Klasse:" + auswahl + " ");
    }//GEN-LAST:event_btn_class_editActionPerformed

    private void lst_faecherValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_faecherValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lst_faecherValueChanged

    private void btn_fach_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fach_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_fach_editActionPerformed

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
    private javax.swing.JPanel Activities;
    private javax.swing.JButton btn_action_new;
    private javax.swing.JButton btn_action_reset;
    private javax.swing.JButton btn_class_edit;
    private javax.swing.JButton btn_class_new;
    private javax.swing.JButton btn_class_show;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_fach_edit;
    private javax.swing.JButton btn_fach_new;
    private javax.swing.JButton btn_splan_current;
    private javax.swing.JButton btn_splan_new;
    private javax.swing.JButton btn_splan_prev;
    private javax.swing.JButton btn_teacher_edit;
    private javax.swing.JButton btn_teacher_new;
    private javax.swing.JButton btn_teacher_show;
    private javax.swing.JList jList1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbl_window_title;
    private javax.swing.JList lst_class;
    private javax.swing.JList lst_faecher;
    private javax.swing.JList lst_teacher;
    private javax.swing.JMenuItem menu_close;
    private javax.swing.JMenu menu_datei;
    private javax.swing.JMenu menu_hilfe;
    private javax.swing.JMenuItem menu_ueber;
    private javax.swing.JPanel tab_classes;
    private javax.swing.JTabbedPane tab_sections;
    private javax.swing.JPanel tab_splan;
    private javax.swing.JPanel tab_subjects;
    private javax.swing.JPanel tab_teacher;
    // End of variables declaration//GEN-END:variables
}