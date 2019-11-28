/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan.oberflaechen;

import stundenplan.datenbank.IConnection;
import stundenplan.datenbank.DatenbankFabrik;
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
    private IConnection verbinde = null;
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
            verbinde = DatenbankFactory.getIConnection();
            klassen = verbinde.holeKlassen();
            lehrer = verbinde.holeLehrer();
            faecher = verbinde.holeFaecher();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
        } finally {
            if (verbinde != null) {
                verbinde.schliesseVerbindung();
            }
        }

        initComponents();
        // Zentriert das Fenster
        setLocationRelativeTo(this);

        // Klassen Liste füllen
        KlassenListModel klassenList = new KlassenListModel(klassen);
        lst_klassen.setModel(klassenList);

        // Lehrer Liste füllen
        LehrerListModel lehrerList = new LehrerListModel(lehrer);
        lst_lehrer.setModel(lehrerList);

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

        btn_programm_beenden = new javax.swing.JButton();
        tab_bereiche = new javax.swing.JTabbedPane();
        tab_stundenplan = new javax.swing.JPanel();
        btn_aktuelle_stundenplaene_anzeigen = new javax.swing.JButton();
        btn_stundenplan_anlegen = new javax.swing.JButton();
        btn_stundenplan_anzeigen = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        tab_teacher = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_lehrer = new javax.swing.JList();
        btn_lehrer_stundenplan_anzeigen = new javax.swing.JButton();
        btn_lehrer_bearbeiten = new javax.swing.JButton();
        btn_lehrer_anlegen = new javax.swing.JButton();
        tab_classes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_klassen = new javax.swing.JList();
        btn_klassen_stundenplan_anzeigen = new javax.swing.JButton();
        btn_klasse_bearbeiten = new javax.swing.JButton();
        btn_klasse_anlegen = new javax.swing.JButton();
        tab_faecher = new javax.swing.JPanel();
        btn_fach_anlegen = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lst_faecher = new javax.swing.JList();
        btn_fach_bearbeiten = new javax.swing.JButton();
        tab_aktivitaeten = new javax.swing.JPanel();
        btn_aktivitaet_anlegen = new javax.swing.JButton();
        btn_aktivitaet_zuruecksetzen = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lst_aktivitaeten = new javax.swing.JList();
        jMenuBar2 = new javax.swing.JMenuBar();
        menu_datei = new javax.swing.JMenu();
        menu_beenden = new javax.swing.JMenuItem();
        menu_hilfe = new javax.swing.JMenu();
        menu_ueber = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stundenplanverwaltungsoberfläche");

        btn_programm_beenden.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_programm_beenden.setText("Programm beenden");
        btn_programm_beenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_programm_beendenActionPerformed(evt);
            }
        });

        tab_bereiche.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btn_aktuelle_stundenplaene_anzeigen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_aktuelle_stundenplaene_anzeigen.setText("Aktuelle Stundenpläne ansehen");
        btn_aktuelle_stundenplaene_anzeigen.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_aktuelle_stundenplaene_anzeigen.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_aktuelle_stundenplaene_anzeigen.setPreferredSize(new java.awt.Dimension(220, 50));

        btn_stundenplan_anlegen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_stundenplan_anlegen.setText("Neuen Stundenplan anlegen");
        btn_stundenplan_anlegen.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_stundenplan_anlegen.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_stundenplan_anlegen.setPreferredSize(new java.awt.Dimension(220, 50));

        btn_stundenplan_anzeigen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_stundenplan_anzeigen.setText("Stundenplan ansehen");
        btn_stundenplan_anzeigen.setMaximumSize(new java.awt.Dimension(200, 30));
        btn_stundenplan_anzeigen.setMinimumSize(new java.awt.Dimension(200, 30));
        btn_stundenplan_anzeigen.setPreferredSize(new java.awt.Dimension(220, 50));
        btn_stundenplan_anzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stundenplan_anzeigenActionPerformed(evt);
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

        javax.swing.GroupLayout tab_stundenplanLayout = new javax.swing.GroupLayout(tab_stundenplan);
        tab_stundenplan.setLayout(tab_stundenplanLayout);
        tab_stundenplanLayout.setHorizontalGroup(
            tab_stundenplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(tab_stundenplanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_stundenplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_aktuelle_stundenplaene_anzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btn_stundenplan_anlegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(tab_stundenplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(btn_stundenplan_anzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        tab_stundenplanLayout.setVerticalGroup(
            tab_stundenplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_stundenplanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_stundenplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_stundenplanLayout.createSequentialGroup()
                        .addComponent(btn_aktuelle_stundenplaene_anzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_stundenplan_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 122, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_stundenplanLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_stundenplan_anzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tab_bereiche.addTab("Stundenpläne", tab_stundenplan);

        lst_lehrer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lst_lehrer.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Lehrer 1", "Lehrer 2", "Lehrer 3", "Lehrer 4", "Lehrer 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_lehrer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lst_lehrer.setMaximumSize(new java.awt.Dimension(150, 50));
        lst_lehrer.setMinimumSize(new java.awt.Dimension(150, 50));
        lst_lehrer.setPreferredSize(new java.awt.Dimension(150, 50));
        lst_lehrer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_lehrerValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lst_lehrer);

        btn_lehrer_stundenplan_anzeigen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_lehrer_stundenplan_anzeigen.setText("Stundenplan anzeigen");
        btn_lehrer_stundenplan_anzeigen.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_lehrer_stundenplan_anzeigen.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_lehrer_stundenplan_anzeigen.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_lehrer_stundenplan_anzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lehrer_stundenplan_anzeigenActionPerformed(evt);
            }
        });

        btn_lehrer_bearbeiten.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_lehrer_bearbeiten.setText("Lehrer bearbeiten");
        btn_lehrer_bearbeiten.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_lehrer_bearbeiten.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_lehrer_bearbeiten.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_lehrer_bearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lehrer_bearbeitenActionPerformed(evt);
            }
        });

        btn_lehrer_anlegen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_lehrer_anlegen.setText("Neue Lehrer anlegen");
        btn_lehrer_anlegen.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_lehrer_anlegen.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_lehrer_anlegen.setPreferredSize(new java.awt.Dimension(180, 40));

        javax.swing.GroupLayout tab_teacherLayout = new javax.swing.GroupLayout(tab_teacher);
        tab_teacher.setLayout(tab_teacherLayout);
        tab_teacherLayout.setHorizontalGroup(
            tab_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_teacherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_lehrer_stundenplan_anzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lehrer_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lehrer_bearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        tab_teacherLayout.setVerticalGroup(
            tab_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_teacherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_teacherLayout.createSequentialGroup()
                        .addComponent(btn_lehrer_stundenplan_anzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_lehrer_bearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_lehrer_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab_bereiche.addTab("Lehrer", tab_teacher);

        lst_klassen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lst_klassen.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Klasse 1", "Klasse 2", "Klasse 3", "Klasse 4", "Klasse 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_klassen.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lst_klassen.setMaximumSize(new java.awt.Dimension(150, 50));
        lst_klassen.setMinimumSize(new java.awt.Dimension(150, 50));
        lst_klassen.setPreferredSize(new java.awt.Dimension(150, 50));
        jScrollPane2.setViewportView(lst_klassen);

        btn_klassen_stundenplan_anzeigen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_klassen_stundenplan_anzeigen.setText("Stundenplan anzeigen");
        btn_klassen_stundenplan_anzeigen.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_klassen_stundenplan_anzeigen.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_klassen_stundenplan_anzeigen.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_klassen_stundenplan_anzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_klassen_stundenplan_anzeigenActionPerformed(evt);
            }
        });

        btn_klasse_bearbeiten.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_klasse_bearbeiten.setText("Klasse bearbeiten");
        btn_klasse_bearbeiten.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_klasse_bearbeiten.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_klasse_bearbeiten.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_klasse_bearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_klasse_bearbeitenActionPerformed(evt);
            }
        });

        btn_klasse_anlegen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_klasse_anlegen.setText("Neue Klasse anlegen");
        btn_klasse_anlegen.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_klasse_anlegen.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_klasse_anlegen.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_klasse_anlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_klasse_anlegenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab_classesLayout = new javax.swing.GroupLayout(tab_classes);
        tab_classes.setLayout(tab_classesLayout);
        tab_classesLayout.setHorizontalGroup(
            tab_classesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_classesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_classesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_klassen_stundenplan_anzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_klasse_bearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_klasse_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        tab_classesLayout.setVerticalGroup(
            tab_classesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_classesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_classesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_classesLayout.createSequentialGroup()
                        .addComponent(btn_klassen_stundenplan_anzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_klasse_bearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_klasse_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab_bereiche.addTab("Klassen", tab_classes);

        btn_fach_anlegen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_fach_anlegen.setText("Neues Fach");
        btn_fach_anlegen.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_fach_anlegen.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_fach_anlegen.setPreferredSize(new java.awt.Dimension(180, 40));

        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

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

        btn_fach_bearbeiten.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_fach_bearbeiten.setText("Fach bearbeiten");
        btn_fach_bearbeiten.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_fach_bearbeiten.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_fach_bearbeiten.setPreferredSize(new java.awt.Dimension(180, 40));
        btn_fach_bearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fach_bearbeitenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab_faecherLayout = new javax.swing.GroupLayout(tab_faecher);
        tab_faecher.setLayout(tab_faecherLayout);
        tab_faecherLayout.setHorizontalGroup(
            tab_faecherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_faecherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_faecherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_fach_bearbeiten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_fach_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        tab_faecherLayout.setVerticalGroup(
            tab_faecherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_faecherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_faecherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addGroup(tab_faecherLayout.createSequentialGroup()
                        .addComponent(btn_fach_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btn_fach_bearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tab_bereiche.addTab("Fächer", tab_faecher);

        btn_aktivitaet_anlegen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_aktivitaet_anlegen.setText("Neue Aktivität");
        btn_aktivitaet_anlegen.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_aktivitaet_anlegen.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_aktivitaet_anlegen.setPreferredSize(new java.awt.Dimension(180, 40));

        btn_aktivitaet_zuruecksetzen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_aktivitaet_zuruecksetzen.setText("Aktivitäten zurücksetzen");
        btn_aktivitaet_zuruecksetzen.setMaximumSize(new java.awt.Dimension(180, 40));
        btn_aktivitaet_zuruecksetzen.setMinimumSize(new java.awt.Dimension(180, 40));
        btn_aktivitaet_zuruecksetzen.setPreferredSize(new java.awt.Dimension(180, 40));

        jScrollPane5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lst_aktivitaeten.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lst_aktivitaeten.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Aktivität 1", "Aktivität 2", "Aktivität 3", "Aktivität 4", "Aktivität 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_aktivitaeten.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lst_aktivitaeten.setMaximumSize(new java.awt.Dimension(150, 50));
        lst_aktivitaeten.setMinimumSize(new java.awt.Dimension(150, 50));
        lst_aktivitaeten.setPreferredSize(new java.awt.Dimension(150, 50));
        lst_aktivitaeten.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_aktivitaetenValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(lst_aktivitaeten);

        javax.swing.GroupLayout tab_aktivitaetenLayout = new javax.swing.GroupLayout(tab_aktivitaeten);
        tab_aktivitaeten.setLayout(tab_aktivitaetenLayout);
        tab_aktivitaetenLayout.setHorizontalGroup(
            tab_aktivitaetenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_aktivitaetenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_aktivitaetenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_aktivitaet_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aktivitaet_zuruecksetzen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        tab_aktivitaetenLayout.setVerticalGroup(
            tab_aktivitaetenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_aktivitaetenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_aktivitaetenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addGroup(tab_aktivitaetenLayout.createSequentialGroup()
                        .addComponent(btn_aktivitaet_anlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addComponent(btn_aktivitaet_zuruecksetzen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tab_bereiche.addTab("Aktivitäten", tab_aktivitaeten);

        menu_datei.setText("Datei");
        menu_datei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dateiActionPerformed(evt);
            }
        });

        menu_beenden.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menu_beenden.setText("Programm beenden");
        menu_beenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_beendenActionPerformed(evt);
            }
        });
        menu_datei.add(menu_beenden);

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
                    .addComponent(tab_bereiche)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_programm_beenden)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tab_bereiche, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_programm_beenden)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_klasse_anlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_klasse_anlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_klasse_anlegenActionPerformed

    private void btn_stundenplan_anzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stundenplan_anzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_stundenplan_anzeigenActionPerformed

    private void btn_programm_beendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_programm_beendenActionPerformed
        String message = "Wollen Sie die Stundenplanverwaltungsoberfläche wirklich beenden?";
        String title = "Sind Sie sich sicher?";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
          System.exit(0);
        }
    }//GEN-LAST:event_btn_programm_beendenActionPerformed

    private void menu_ueberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ueberActionPerformed
        String nachricht = "Die Stundenplanverwaltungsoberfläche für das Ludwig-Erhard Berufskolleg, Münster" +"\n\n"+
                        "Diese Software wurde während einer Gruppenarbeit erstellt" +"\n"+
                                "von Gruppe E der Klasse ITFO3 2019";
        String fenstertitel = "Stundenplanverwaltungsoberfläche";
        // Info Panel
        JOptionPane.showMessageDialog(null, nachricht, fenstertitel,JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menu_ueberActionPerformed

    private void menu_dateiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_dateiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_dateiActionPerformed

    private void menu_beendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_beendenActionPerformed
        /* Strings für die Meldung befüllen */
        String fensternachricht = "Wollen Sie die Stundenplanverwaltungsoberfläche wirklich beenden?";
        String fenstertitel = "Sind Sie sich sicher?";
        /* Schließen Disalog aufrufen und Antwort verarbeiten */
        int beendendialog = JOptionPane.showConfirmDialog(null, fensternachricht, fenstertitel, JOptionPane.YES_NO_OPTION);
        if (beendendialog == JOptionPane.YES_OPTION){
          System.exit(0);
        }
    }//GEN-LAST:event_menu_beendenActionPerformed

    private void lst_lehrerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_lehrerValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lst_lehrerValueChanged

    private void btn_lehrer_bearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lehrer_bearbeitenActionPerformed
        /* Gewählten Lehrer aus der Liste herausfinden */
        String auswahl = (String) lst_lehrer.getSelectedValue();
        /* Neue GUI mit dem ausgewählten Lehrer aufrufen */
        new LehrerEditGUI(auswahl).setVisible(true);
    }//GEN-LAST:event_btn_lehrer_bearbeitenActionPerformed

    private void btn_lehrer_stundenplan_anzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lehrer_stundenplan_anzeigenActionPerformed
        /* Gewählten Lehrer aus der Liste herausfinden */
        String auswahl = (String) lst_lehrer.getSelectedValue();
        System.out.println("L-Stundenplan für:" + auswahl + " ");
    }//GEN-LAST:event_btn_lehrer_stundenplan_anzeigenActionPerformed

    private void btn_klassen_stundenplan_anzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_klassen_stundenplan_anzeigenActionPerformed
        /* Gewählte Klasse aus der Liste herausfinden */
        String auswahl = (String) lst_klassen.getSelectedValue();
        System.out.println("K-Stundenplan für:" + auswahl + " ");
    }//GEN-LAST:event_btn_klassen_stundenplan_anzeigenActionPerformed

    private void btn_klasse_bearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_klasse_bearbeitenActionPerformed
        /* Gewählte Klasse aus der Liste herausfinden */
        String auswahl = (String) lst_klassen.getSelectedValue();
        System.out.println("gewählte Klasse:" + auswahl + " ");
    }//GEN-LAST:event_btn_klasse_bearbeitenActionPerformed

    private void lst_faecherValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_faecherValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lst_faecherValueChanged

    private void btn_fach_bearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fach_bearbeitenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_fach_bearbeitenActionPerformed

    private void lst_aktivitaetenValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_aktivitaetenValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lst_aktivitaetenValueChanged

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
    private javax.swing.JButton btn_aktivitaet_anlegen;
    private javax.swing.JButton btn_aktivitaet_zuruecksetzen;
    private javax.swing.JButton btn_aktuelle_stundenplaene_anzeigen;
    private javax.swing.JButton btn_fach_anlegen;
    private javax.swing.JButton btn_fach_bearbeiten;
    private javax.swing.JButton btn_klasse_anlegen;
    private javax.swing.JButton btn_klasse_bearbeiten;
    private javax.swing.JButton btn_klassen_stundenplan_anzeigen;
    private javax.swing.JButton btn_lehrer_anlegen;
    private javax.swing.JButton btn_lehrer_bearbeiten;
    private javax.swing.JButton btn_lehrer_stundenplan_anzeigen;
    private javax.swing.JButton btn_programm_beenden;
    private javax.swing.JButton btn_stundenplan_anlegen;
    private javax.swing.JButton btn_stundenplan_anzeigen;
    private javax.swing.JList jList1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList lst_aktivitaeten;
    private javax.swing.JList lst_faecher;
    private javax.swing.JList lst_klassen;
    private javax.swing.JList lst_lehrer;
    private javax.swing.JMenuItem menu_beenden;
    private javax.swing.JMenu menu_datei;
    private javax.swing.JMenu menu_hilfe;
    private javax.swing.JMenuItem menu_ueber;
    private javax.swing.JPanel tab_aktivitaeten;
    private javax.swing.JTabbedPane tab_bereiche;
    private javax.swing.JPanel tab_classes;
    private javax.swing.JPanel tab_faecher;
    private javax.swing.JPanel tab_stundenplan;
    private javax.swing.JPanel tab_teacher;
    // End of variables declaration//GEN-END:variables
}
