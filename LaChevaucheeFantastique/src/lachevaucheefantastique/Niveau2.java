/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class Niveau2 extends JFrame {

    private JButton[][] boutons;
    private int chevalierX, chevalierY;

    public Niveau2() {
        super();
        // Affichage de la fenêtre
        setTitle("Chess Knight Moves - Niveau 2");
        setSize(400, 400); // Ajustez la taille selon vos besoins
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4));

        // Niveau 2
        boutons = new JButton[4][4]; // fenêtre de boutons en 4x4
        chevalierX = 3; // Position initiale en bas
        chevalierY = 0; // Position initiale à gauche

        initialiserGrilleNiveau2();
        deplacement();

        setVisible(true);
    }

    private void initialiserGrilleNiveau2() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setBackground(Color.GRAY);
                boutons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(boutons[i][j]);
            }
        }
        // Initialisation de quelques cases allumées - LVL 2
        boutons[0][1].setBackground(Color.YELLOW);
        boutons[2][2].setBackground(Color.YELLOW);
        boutons[3][3].setBackground(Color.YELLOW);
        boutons[2][0].setBackground(Color.YELLOW);
        boutons[1][2].setBackground(Color.YELLOW);
    }

    private void deplacement() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == chevalierX && j == chevalierY) {
                    boutons[i][j].setText("♞");
                } else {
                    boutons[i][j].setText("");
                }
            }
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
                chevalierX = x;
                chevalierY = y;
                boutons[x][y].setBackground(
                        boutons[x][y].getBackground() == Color.YELLOW ? Color.GRAY : Color.YELLOW
                );
                deplacement();
                verifVictoire();
            } else {
                JOptionPane.showMessageDialog(
                        Niveau2.this,
                        "Mouvement impossible ou case grise",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        private boolean possibleDeplacement(int newX, int newY) {
            int dx = newX - chevalierX;
            int dy = newY - chevalierY;

            // Vérification que la case cible est allumée
            if (boutons[newX][newY].getBackground() != Color.YELLOW) {
                return false;
            }

            return (dx == 1 || dx == -1) && (dy == 2 || dy == -2) || (dx == 2 || dx == -2) && (dy == 1 || dy == -1);
        }
    }

    private void verifVictoire() {
        boolean toutEteint = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (boutons[i][j].getBackground() == Color.YELLOW) {
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
            new FenetreVictoire2().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Niveau2());
    }
}
