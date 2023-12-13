/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lachevaucheefantastique;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author leafr
 */
public class Intro extends javax.swing.JFrame {

    int nbLignes;
    int nbColonnes;

    /**
     * Creates new form Intro
     */
    public Intro() {
        initComponents();
        Aventure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReglesAventurePopup();
                setVisible(false);
                new Niveau1graph();

            }
        });

        Libre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReglesLibrePopup();
                setVisible(false);
                new Modelibregraph();

            }
        });
    }

    private void ReglesLibrePopup() {
        String rulesText = "Règles spéciales Mode Libre:\n"
                + "- Règle 1: Tu peux te déplacer sur les cases grises.\n"
                + "- Règle 2: Tu as un nombre de coups limités.\n"
                + "- Règle 3: More rules as needed.";
        JOptionPane.showMessageDialog(this, rulesText, "Mode Libre Règles", JOptionPane.INFORMATION_MESSAGE);
    }
    private void ReglesAventurePopup() {
        String rulesText = "Règles spéciales Mode Aventure:\n"
                + "- Règle 1: Tu ne peux pas te déplacer sur une case grise.\n"
                + "- Règle 2: Tu n'as pas un nombre de coups limités.\n"
                + "- Règle 3: Si tu es bloqué cliques sur reset ou abandonne.";
        JOptionPane.showMessageDialog(this, rulesText, "Mode Libre Règles", JOptionPane.INFORMATION_MESSAGE);
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
        Libre = new javax.swing.JButton();
        Aventure = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Libre.setText("Mode Libre");
        Libre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibreActionPerformed(evt);
            }
        });
        jPanel1.add(Libre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 120, 40));

        Aventure.setText("Mode Aventure");
        Aventure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AventureActionPerformed(evt);
            }
        });
        jPanel1.add(Aventure, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 120, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" et d'une case dans une direction perpendiculaire");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Règles communes aux 2 modes :      ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 400, 30));
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" - Le cavalier avance de 2 cases dans une direction,");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" - Lorsque le cavalier atterrit sur une case allumée, il l'éteint.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 426, 380, 60));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bienvenue dans la Chevauchée Fantastique !");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lachevaucheefantastique/noir.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 420, 180));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lachevaucheefantastique/Image.jpg"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, -30, 690, 860));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -170, 630, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AventureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AventureActionPerformed

    }//GEN-LAST:event_AventureActionPerformed

    private void LibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibreActionPerformed

    }//GEN-LAST:event_LibreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Intro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aventure;
    private javax.swing.JButton Libre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
