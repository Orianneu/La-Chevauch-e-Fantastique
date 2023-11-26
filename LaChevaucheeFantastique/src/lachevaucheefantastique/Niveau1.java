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
 * @author ogues
 */

public class Niveau1 extends JFrame {
    private JButton[][] boutons;
    private int chevalierX, chevalierY;

    public Niveau1() {
        //Affichage de la fenêtre
        setTitle("Chess Knight Moves"); 
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        //Niveau 1
        boutons = new JButton[3][3]; // fenêtre de boutons en 3x3
        chevalierX = 2; //Position initiale en bas
        chevalierY = 0; //Position initiale à gauche

        initialisergrille();
        deplacement();

        setVisible(true);
    }

    private void initialisergrille() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setBackground(Color.GRAY);
                boutons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(boutons[i][j]);
            }
        }
        // Initialisation de quelques cases allumées - LVL 1
        boutons[0][1].setBackground(Color.YELLOW);
        boutons[2][2].setBackground(Color.YELLOW);
    }

    private void deplacement() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == chevalierX && j == chevalierY) {
                    boutons[i][j].setText("♞");
                } else {
                    boutons[i][j].setText("");
                }
            }
        }
    }

    private void verifvictoire() {
        boolean touteteint = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boutons[i][j].getBackground() == Color.YELLOW) {
                    touteteint = false;
                    break;
                }
            }
            if (!touteteint) {
                break;
            }
        }

        if (touteteint) {
            setVisible(false);
            new FenetreVictoire();
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
            if (possibledeplacement(x, y)) {
                chevalierX = x; //déplace le chevalier sur la coordonnée X
                chevalierY = y; //déplace le chevalier sur la coordonnée Y
                boutons[x][y].setBackground(
                        boutons[x][y].getBackground() == Color.YELLOW ? Color.GRAY : Color.YELLOW
                );
                deplacement();
                verifvictoire();
            } else {
                JOptionPane.showMessageDialog(
                        Niveau1.this,
                        "Mouvement impossible ou case grise",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        private boolean possibledeplacement(int newX, int newY) {
            int dx = newX - chevalierX;
            int dy = newY - chevalierY;

            // Vérification que la case cible est allumée
            if (boutons[newX][newY].getBackground() != Color.YELLOW) {
                return false;
            }

            return (dx == 1 || dx == -1) && (dy == 2 || dy == -2) || (dx == 2 || dx == -2) && (dy == 1 || dy == -1);
        }
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Niveau1());
    }
}

