package lachevaucheefantastique;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import lachevaucheefantastique.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author leafr
 */
public class Modelibregraph extends JFrame {

    private final JButton[][] boutons;
    private int cavalierX, cavalierY;
    private final int[][] etatsCases;

    /**
     * Permet de créer une grille 3x3 boutons, chaque bouton à un fond gris, une
     * hauteur de 70 pixels et deux boutons spécifiques ont un fond jaune avec
     * un cavallier positionné sur un autre bouton. Un bouton abandonner est
     * également ajouté en bas de la fenêtre.
     */
    public Modelibregraph() {
        initComponents();
        setTitle("Niveau 1 Mode Libre");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel mainPanel = new JPanel(new GridLayout(5, 5));
        
        boutons = new JButton[5][5];
        etatsCases = new int[5][5];
        cavalierX = 2;
        cavalierY = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setBackground(Color.GRAY);
                boutons[i][j].setPreferredSize(new Dimension(0, 70));
                boutons[i][j].addActionListener(new ButtonClickListener(i, j));
                etatsCases[i][j] = 0;
                mainPanel.add(boutons[i][j]);
            }
        }

        boutons[cavalierX][cavalierY].setText("♞");

        JButton abandonnerButton = new JButton("Abandonner");

        add(mainPanel, BorderLayout.CENTER);
        add(abandonnerButton, BorderLayout.SOUTH);
        allumerCasesAleatoires();
    }

    private void allumerCasesAleatoires() {
        int nombreCasesAllumees = 3; // Vous pouvez ajuster ce nombre selon vos besoins
        for (int i = 0; i < nombreCasesAllumees; i++) {
            int x = (int) (Math.random() * 5);
            int y = (int) (Math.random() * 5);

            // Assurez-vous que la case n'est pas déjà allumée
            if (etatsCases[x][y] != 1) {
                etatsCases[x][y] = 1; // 1 représente l'état jaune
                boutons[x][y].setBackground(Color.YELLOW);
            } else {
                // Si la case est déjà allumée, décrémentez 'i' pour répéter la boucle pour une autre case
                i--;
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
            new FenetreVictoireLibre().setVisible(true);
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
                etatsCases[cavalierX][cavalierY] = 0; // Définir l'état de la case actuelle à gris
                cavalierX = x;
                cavalierY = y;
                boutons[cavalierX][cavalierY].setBackground(Color.GRAY);
                
                deplacement();
                verifVictoire();
            } else {
                JOptionPane.showMessageDialog(
                        Modelibregraph.this,
                        "Mouvement impossible",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        private boolean possibleDeplacement(int newX, int newY) {
            int dx = newX - cavalierX;
            int dy = newY - cavalierY;

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

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modelibregraph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}