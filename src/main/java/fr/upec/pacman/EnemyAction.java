package fr.upec.pacman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyAction implements ActionListener {
    // H jvais les transeformer en tableau
    private int vxb = 3;
    private int vyb = 3;
    private int vxp = 3;
    private int vyp = 3;
    private int vxo = 3;
    private int vyo = 3;
    private int vxr = 3;
    private int vyr = 3;
    private int cmpb;
    private int cmpr;
    private int cmpo;
    private int cmpp;
    private ImageSet entity;
    private GameView p;
    private boolean tour = true; // Choix
    private boolean tour2 = true;
    private boolean tour3 = true;
    private boolean tour4 = true;

    public EnemyAction(ImageSet entity, GameView p) {
        this.entity = entity;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // rechercher les enemies :
        if (!p.getGame().win()) {

            // Blue
            if (tour) {
                if (entity.tabx()[0] <= 36 || entity.tabx()[0] >= 36 * 7) {
                    vxb = vxb * -1; // Inverse axe X
                }
                entity.tabx()[0] = entity.tabx()[0] + vxb;
                p.repaint();
                cmpb++;
                if (cmpb == 12) {
                    tour = false;
                    cmpb = 0;
                }
            } else {

                if (entity.taby()[0] < 36 + 1 | entity.taby()[0] >= 36 * 7 - 1) {
                    // Random direction :
                    vyb = vyb * -1;
                }
                entity.taby()[0] = entity.taby()[0] + vyb;
                p.repaint();
                cmpb++;
                if (cmpb == 36) {
                    tour = true;
                    cmpb = 0;
                }
            }
            // Verifie si ca touche
            if (p.getGame().checkLife()) {
                try {
                    cmpb = 0;
                    cmpo = 0;
                    cmpp = 0;
                    cmpr = 0; // On restart le compteur de chaque fantomessi l'un d'entre eux touche pacman !!
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }
            }

            // Red
            if (tour2) {
                if (entity.tabx()[1] <= 36 || entity.tabx()[1] >= 36 * 7) {
                    vxr = vxr * -1;
                }

                entity.tabx()[1] = entity.tabx()[1] + vxr;
                cmpr++;
                p.repaint();
                if (cmpr == 24) {
                    tour2 = false;
                    cmpr = 0;
                }

            } else {
                if (entity.taby()[1] < 36 + 1 | entity.taby()[1] >= 36 * 7 - 1) {
                    vyr = vyr * -1;
                }
                entity.taby()[1] = entity.taby()[1] + vyr;
                cmpr++;
                if (cmpr == 24) {
                    tour2 = true;
                    cmpr = 0;
                }
                p.repaint();
            }
            // Verifie si ca touche
            if (p.getGame().checkLife()) {
                try {
                    cmpb = 0;
                    cmpo = 0;
                    cmpp = 0;
                    cmpr = 0; // On restart le compteur de chaque fantomessi l'un d'entre eux touche pacman !!
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }


            //Purple
            if (!tour3) {
                if (entity.tabx()[2] <= 36 || entity.tabx()[2] >= 36 * 7) {
                    vxp = vxp * -1;
                }
                entity.tabx()[2] = entity.tabx()[2] + vxp;
                cmpp++;
                if (cmpp == 12) {
                    tour3 = true;
                    cmpp = 0;
                }
                p.repaint();
            } else {
                if (entity.taby()[2] < 36 + 1 | entity.taby()[2] >= 36 * 7 - 1) {
                    vyp = vyp * -1;
                }
                entity.taby()[2] = entity.taby()[2] + vyp;
                cmpp++;
                if (cmpp == 24) {
                    tour3 = false;
                    cmpp = 0;
                }
                p.repaint();
            }

            // Verifie si ca touche
            if (p.getGame().checkLife()) {
                try {
                    cmpb = 0;
                    cmpo = 0;
                    cmpp = 0;
                    cmpr = 0; // On restart le compteur de chaque fantomessi l'un d'entre eux touche pacman !!
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

            // Orange
            if (!tour4) {
                if (entity.tabx()[3] <= 36 || entity.tabx()[3] >= 36 * 7) {
                    vxo = vxo * -1;
                }
                entity.tabx()[3] = entity.tabx()[3] + vxo;
                cmpo++;
                if (cmpo == 24) {
                    tour4 = true;
                    cmpo = 0;
                }
                p.repaint();
            } else {
                if (entity.taby()[3] < 36 + 1 | entity.taby()[3] >= 36 * 7 - 1) {
                    vyo = vyo * -1;
                }
                entity.taby()[3] = entity.taby()[3] + vyo;
                cmpo++;
                if (cmpo == 36) {
                    tour4 = false;
                    cmpo = 0;
                }
                p.repaint();
            }
            // Verifie si ca touche
            if (p.getGame().checkLife()) {
                try {
                    cmpb = 0;
                    cmpo = 0;
                    cmpp = 0;
                    cmpr = 0; // On restart le compteur de chaque fantomessi l'un d'entre eux touche pacman !!
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}

