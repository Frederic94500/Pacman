package fr.upec.pacman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyAction implements ActionListener {
    private int[] dx = new int[]{3, 3, 3, 3};
    private int[] dy = new int[]{3, 3, 3, 3};
    private int[] cp = new int[4];
    private ImageSet entity;
    private GameView p;
    private boolean[] tour = new boolean[]{true, true, true, true}; // Choix


    public EnemyAction(ImageSet entity, GameView p) {
        this.entity = entity;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        makeMove(0); // Blue
        makeMove(1); // Red
        makeMove(2); // Purple
        makeMove(3); // Orange
    }


    private void makeMove(int id) {
        // rechercher les enemies :
        if (!p.getGame().win()) {
            // Position
            if (tour[id]) {
                // Axe des X
                wall(id, 1);
                entity.tabx()[id] = entity.tabx()[id] + dx[id];
                p.repaint();
                cp[id]++;
                if (cp[id] == 12) {
                    tour[id] = false;
                    cp[id] = 0;
                }
            } else {
                // Axe des y
                wall(id, 2);
                entity.taby()[id] = entity.taby()[id] + dy[id];
                p.repaint();
                cp[id]++;
                if (cp[id] == 36) {
                    tour[id] = true;
                    cp[id] = 0;
                }
            }
            p.repaint();
            checkLife(); // Verifie si ca touche
        }
    }


    private void checkLife() {
        if (p.getGame().checkLife()) {
            try {
                // On restart les compteur de chaque fantomessi l'un d'entre eux touche pacman !!
                for (int i = 0; i < cp.length; i++) {
                    cp[i] = 0;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }


    private void wall(int id, int choix) {
        int x = entity.tabx()[id];
        int y = entity.taby()[id];
        if (choix == 2) {
            if (y == 36) {
                dy[id] = dy[id] * -1;
            }
            if (y == 8 * 36) {
                dy[id] = dy[id] * -1;
            }
            if (y == 3 * 36 & x == 4 * 36 && dy[id] < 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 4 * 36 & (x == 4 * 36 || x == 3 * 36) && dy[id] > 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 6 * 36 & (x == 4 * 36 || x == 3 * 36) && dy[id] < 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 6 * 36 & (x == 6 * 36 || x == 7 * 36 || x == 8 * 36) & dy[id] > 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 8 * 36 & x == 8 * 36 & dy[id] < 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 8 * 36 & x == 6 * 36 & dy[id] < 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 3 * 36 & (x == 12 * 36 || x == 10 * 36) & dy[id] > 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 7 * 36 & x == 12 * 36 & dy[id] < 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 2 * 36 & x == 11 * 36 & dy[id] > 0) {
                dy[id] = dy[id] * -1;
            }
            if (y == 5 * 36 & (x == 11 * 36 || x == 10 * 36) & dy[id] < 0) {
                dy[id] = dy[id] * -1;
            }
        }
        // X    
        if (choix == 1) {
            if (x == 36) {
                dx[id] = dx[id] * -1;
            }
            if (x == 14 * 36) {
                dx[id] = dx[id] * -1;
            }
            if (x == 3 * 36 & (y == 1 * 36 || y == 2 * 36) & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (x == 5 * 36 & (y == 1 * 36 || y == 2 * 36) & dx[id] < 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 5 * 36 & (x == 36 * 2) & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 5 * 36 & (x == 36 * 5) & dx[id] < 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 7 * 36 & x == 5 * 36 & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 7 * 36 & x == 9 * 36 & dx[id] < 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 8 * 36 & x == 6 * 36 & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 8 * 36 & x == 8 * 36 & dx[id] < 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 4 * 36 & x == 9 * 36 & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 4 * 36 & x == 13 * 36 & dx[id] < 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 5 * 36 & x == 13 * 36 & dx[id] < 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 6 * 36 & x == 13 * 36 & dx[id] < 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 4 * 36 & x == 11 * 36 & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 5 * 36 & x == 11 * 36 & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 6 * 36 & x == 11 * 36 & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 3 * 36 & x == 10 * 36 & dx[id] > 0) {
                dx[id] = dx[id] * -1;
            }
            if (y == 3 * 36 & x == 112 * 36 & dx[id] < 0) {
                dx[id] = dx[id] * -1;
            }
        }
    }


}
        



