/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stundenplan;

/**
 * Die zentrale Stundenplan-Klasse
 * @author fielesebastian
 */
public class Stundenplan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set the Look & Feel
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UebersichtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UebersichtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UebersichtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UebersichtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Übersicht anzeigen */
        java.awt.EventQueue.invokeLater(() -> {
            new UebersichtGUI().setVisible(true);
        });
    }
    
}
