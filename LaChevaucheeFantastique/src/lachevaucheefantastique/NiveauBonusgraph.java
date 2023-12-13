/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lachevaucheefantastique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author leafr
 */
public class NiveauBonusgraph extends JFrame {

    private final JButton[][] boutons;
    private int cavalierX, cavalierY;

    // Ajout d'un état pour les cases (0: Gris, 1: Jaune, 2: Orange)
    private final int[][] etatsCases;

    public NiveauBonusgraph() {
        initComponents();
        setTitle("Niveau Bonus");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel mainPanel = new JPanel(new GridLayout(7, 7));
        boutons = new JButton[7][7];
        etatsCases = new int[7][7];
        cavalierX = 6; // Position de départ
        cavalierY = 6;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setBackground(Color.GRAY);
                boutons[i][j].setPreferredSize(new Dimension(0, 70));
                boutons[i][j].addActionListener(new ButtonClickListener(i, j));

                etatsCases[i][j] = 0; // Toutes les cases commencent en gris

                mainPanel.add(boutons[i][j]);
            }
        }

        // Nouvelle configuration de cases allumées - LVL Bonus
        etatsCases[3][0] = 1; // Violet
        etatsCases[4][0] = 1; // Violet
        etatsCases[1][1] = 2; // Violet
        etatsCases[3][1] = 2; // Violet
        etatsCases[6][1] = 3; // Rouge
        etatsCases[1][2] = 1; // Rouge
        etatsCases[3][1] = 1; // Rouge
        etatsCases[4][1] = 1; // Violet
        etatsCases[5][1] = 1; // Rouge
        etatsCases[0][3] = 1; // Rouge
        etatsCases[2][3] = 2; // Rouge
        etatsCases[4][3] = 3; // Rouge
        etatsCases[5][3] = 1; // Rouge
        etatsCases[2][4] = 4; // Rouge
        etatsCases[4][4] = 1; // Rouge
        etatsCases[6][4] = 1; // Rouge
        etatsCases[4][5] = 1; // Rouge

        miseAJourCouleurCases();

        boutons[cavalierX][cavalierY].setText("♞");

        add(mainPanel, BorderLayout.CENTER);

    }

    private void miseAJourCouleurCases() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                switch (etatsCases[i][j]) {
                    case 0:
                        boutons[i][j].setBackground(Color.GRAY);
                        break;
                    case 1:
                        boutons[i][j].setBackground(Color.ORANGE);
                        break;
                    case 2:
                        boutons[i][j].setBackground(Color.YELLOW);
                        break;
                    case 3:
                        boutons[i][j].setBackground(Color.RED);
                        break;
                    case 4:
                        boutons[i][j].setBackground(new Color(128, 0, 128));
                        break;
                }
            }
        }
    }

    private void deplacement() {
        for (JButton[] ligne : boutons) {
            for (JButton bouton : ligne) {
                bouton.setText(bouton == boutons[cavalierX][cavalierY] ? "♞" : "");
            }
        }
        revalidate();
    }

    private void verifVictoire() {
        boolean toutEteint = true;
        for (JButton[] ligne : boutons) {
            for (JButton bouton : ligne) {
                if (bouton.getBackground() == Color.YELLOW) {
                    toutEteint = false;
                    break;
                }
            }
            if (!toutEteint) {
                break;
            }
        }

        if (toutEteint) {
            setVisible(false);
            new FenetreVictoire5().setVisible(true);
        }

    }

    private class ButtonClickListener implements ActionListener {

        private int x, y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (possibleDeplacement(x, y)) {
                cavalierX = x;
                cavalierY = y;
                if (etatsCases[x][y] == 1) {
                    etatsCases[x][y] = 2; // Passage 1 : Orange -> Jaune
                } else if (etatsCases[x][y] == 3) {
                    etatsCases[x][y] = 1; // Passage 2 : Rouge -> Orange
                } else if (etatsCases[x][y] == 4) {
                    etatsCases[x][y] = 3; // Passage 2 : Violet -> Rouge
                } else if (etatsCases[x][y] == 2) {
                    etatsCases[x][y] = 0; // Passage 2 : Jaune -> Gris

                }

                miseAJourCouleurCases();
                deplacement();
                verifVictoire();
            } else {
                JOptionPane.showMessageDialog(NiveauBonusgraph.this,
                        "Mouvement impossible ou case grise",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        private boolean possibleDeplacement(int newX, int newY) {
            int dx = newX - cavalierX;
            int dy = newY - cavalierY;

            // Vérifie si la case est jaune, orange, rouge, violet
            if (etatsCases[newX][newY] != 1 && etatsCases[newX][newY] != 2 && etatsCases[newX][newY] != 3 && etatsCases[newX][newY] != 4 && etatsCases[newX][newY] != 5) {
                return false;
            }

            boolean isPossible = (dx == 1 || dx == -1) && (dy == 2 || dy == -2) || (dx == 2 || dx == -2) && (dy == 1 || dy == -1);
            return isPossible;
        }

    }

    private void abandonnerPartie() {
        setVisible(false);
        new FenetrePerdu().setVisible(true);
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
        Abandonner = new javax.swing.JButton();
        Aide = new javax.swing.JButton();
        Reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        Abandonner.setText("Abandonner");
        Abandonner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbandonnerActionPerformed(evt);
            }
        });
        getContentPane().add(Abandonner, java.awt.BorderLayout.PAGE_START);

        Aide.setText("?");
        Aide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AideActionPerformed(evt);
            }
        });
        getContentPane().add(Aide, java.awt.BorderLayout.PAGE_END);

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        getContentPane().add(Reset, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbandonnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbandonnerActionPerformed
        abandonnerPartie();
    }//GEN-LAST:event_AbandonnerActionPerformed

    private void AideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AideActionPerformed
        JOptionPane.showMessageDialog(NiveauBonusgraph.this,
                "INFORMATION:\nDe nouvelles couleurs viennent d'être ajoutées: orange -> vous devez éteindre la case 2 fois \n rouge -> éteindre 3 fois\n violet -> 4 fois",
                "Aide",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_AideActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        setVisible(false);
        new NiveauBonusgraph();
    }//GEN-LAST:event_ResetActionPerformed

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
            java.util.logging.Logger.getLogger(NiveauBonusgraph.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NiveauBonusgraph.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NiveauBonusgraph.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NiveauBonusgraph.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NiveauBonusgraph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JButton Aide;
    private javax.swing.JButton Reset;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
