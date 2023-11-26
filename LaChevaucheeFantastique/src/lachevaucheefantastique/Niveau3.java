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
public class Niveau3 extends JFrame {
    private JButton[][] boutons;
    private int chevalierX, chevalierY;
    private FenetreVictoire2 fenetreVictoire;

    public Niveau3(FenetreVictoire2 fenetreVictoire) {
        this.fenetreVictoire = fenetreVictoire;
        
        // Affichage de la fenêtre
        setTitle("Chess Knight Moves - Niveau 3");
        setSize(500, 500); // Ajustez la taille selon vos besoins
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 5));

        // Niveau 3
        boutons = new JButton[5][5]; // fenêtre de boutons en 5x5
        chevalierX = 4; // Position initiale en bas
        chevalierY = 0; // Position initiale à gauche

        initialiserGrilleNiveau3();
        deplacement();

        setVisible(true);
    }

    private void initialiserGrilleNiveau3() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setBackground(Color.GRAY);
                boutons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(boutons[i][j]);
            }
        }
        // Initialisation de quelques cases allumées - LVL 3
        boutons[0][2].setBackground(Color.YELLOW);
        boutons[2][3].setBackground(Color.YELLOW);
        boutons[2][2].setBackground(Color.YELLOW);
        boutons[3][3].setBackground(Color.YELLOW);
        boutons[1][0].setBackground(Color.YELLOW);
        boutons[0][3].setBackground(Color.YELLOW);
        boutons[2][1].setBackground(Color.YELLOW);
        boutons[1][2].setBackground(Color.YELLOW);
        boutons[2][4].setBackground(Color.YELLOW);
        boutons[0][4].setBackground(Color.YELLOW);
    }

    private void deplacement() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
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
                        Niveau3.this,
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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
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
       SwingUtilities.invokeLater(() -> new Niveau3(new FenetreVictoire2()));

    }
}

