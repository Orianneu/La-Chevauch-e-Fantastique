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
public class Niveau4graph extends JFrame {

    private final JButton[][] boutons;
    private int cavalierX, cavalierY;

    /**
     Niveau 4 de grille 8x8, chaque bouton à un fond gris, de hauteur 70, à l'exception de 
     * certain bouton spécifiques à fond jaune. La position de départ des cavaliers est défini en amont. 
     * Un bouton pour abandonner la partie est ajouté en bas de la fenêtre. 
     */
    public Niveau4graph() {
        initComponents();
        setTitle("Niveau 4");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel mainPanel = new JPanel(new GridLayout(8, 8));
        boutons = new JButton[8][8];
        cavalierX = 0; //Position de départ
        cavalierY = 7;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setBackground(Color.GRAY);
                boutons[i][j].setPreferredSize(new Dimension(0, 70));
                boutons[i][j].addActionListener(new ButtonClickListener(i, j));

                mainPanel.add(boutons[i][j]);
            }
        }

        // Initialisation de quelques cases allumées - LVL 3
        boutons[0][5].setBackground(Color.YELLOW);
        boutons[2][4].setBackground(Color.YELLOW);
        boutons[3][0].setBackground(Color.YELLOW);
        boutons[6][0].setBackground(Color.YELLOW);
        boutons[7][0].setBackground(Color.YELLOW);
        boutons[1][1].setBackground(Color.YELLOW);
        boutons[4][1].setBackground(Color.YELLOW);
        boutons[6][5].setBackground(Color.YELLOW);
        boutons[3][2].setBackground(Color.YELLOW);
        boutons[6][2].setBackground(Color.YELLOW);
        boutons[4][4].setBackground(Color.YELLOW);
        boutons[4][1].setBackground(Color.YELLOW);
        boutons[7][2].setBackground(Color.YELLOW);
        boutons[5][3].setBackground(Color.YELLOW);
        boutons[2][6].setBackground(Color.YELLOW);
        boutons[5][1].setBackground(Color.YELLOW);
        boutons[3][6].setBackground(Color.YELLOW);
        boutons[0][5].setBackground(Color.YELLOW);
       

        boutons[cavalierX][cavalierY].setText("♞");


        add(mainPanel, BorderLayout.CENTER);
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
            new FenetreVictoire4().setVisible(true);
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
                boutons[cavalierX][cavalierY].setBackground(
                        boutons[cavalierX][cavalierY].getBackground() == Color.YELLOW ? Color.GRAY : Color.YELLOW
                );
                deplacement();
                verifVictoire();
            } else {
                JOptionPane.showMessageDialog(Niveau4graph.this,
                        "Mouvement impossible ou case grise",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        private boolean possibleDeplacement(int newX, int newY) {
            int dx = newX - cavalierX;
            int dy = newY - cavalierY;

            if (boutons[newX][newY].getBackground() != Color.YELLOW) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        Abandonner.setText("Abandonner");
        Abandonner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbandonnerActionPerformed(evt);
            }
        });
        getContentPane().add(Abandonner, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbandonnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbandonnerActionPerformed
        abandonnerPartie();
    }//GEN-LAST:event_AbandonnerActionPerformed

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
            java.util.logging.Logger.getLogger(Niveau4graph.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Niveau4graph.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Niveau4graph.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Niveau4graph.class
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
                new Niveau4graph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
