package fr.upec.pacman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyAction implements ActionListener {
    private int vxb = 36;
    private int vyb = 36;
    private int vxp = 36;
    private int vyp = 36;
    private int vxo = 36;
    private int vyo = 36;
    private int vxr = 36;
    private int vyr = 36;
    private int cmpb;
    private int cmpr;
    private int cmpo;
    private int cmpp;
    private ImageSet entity;
    private GameView p;

    public EnemyAction(ImageSet entity, GameView p) {
        this.entity = entity;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // rechercher les enemies :
    	   if (!p.getGame().win())  {
        // Blue
        if (cmpb % 4 == 0) {
            if (entity.getBx() <= 36 || entity.getBx() >= 36 * 7) {
                vxb = vxb * -1; // Inverse axe X
            }

            entity.setBx(entity.getBx() + vxb);


            cmpb++;
            p.repaint();
        } else {
            if (entity.getBy() < 36 + 1 | entity.getBy() >= 36 * 7 - 1) {
                // Random direction :
                vyb = vyb * -1;
            }
            entity.setBy(entity.getBy() + vyb);

            cmpb++;
            p.repaint();
        }


        // Red
        if (cmpr % 3 == 0) {
            if (entity.getRx() <= 36 || entity.getRx() >= 36 * 7) {
                vxr = vxr * -1;
            }
            entity.setRx(entity.getRx() + vxr);

            cmpr++;
            p.repaint();
        } else {
            if (entity.getRy() < 36 + 1 | entity.getRy() >= 36 * 7 - 1) {
                vyr = vyr * -1;
            }
            entity.setRy(entity.getRy() + vyr);

            cmpr++;
            p.repaint();
        }


        //Purple
        if (cmpp % 5 == 0) {
            if (entity.getPx() <= 36 || entity.getPx() >= 36 * 7) {
                vxp = vxp * -1;
            }
            entity.setPx(entity.getPx() + vxp);

            cmpp++;
            p.repaint();
        } else {
            if (entity.getPy() < 36 + 1 | entity.getPy() >= 36 * 7 - 1) {
                vyp = vyp * -1;
            }
            entity.setPy(entity.getPy() + vyp);

            cmpp++;
            p.repaint();
        }

        // Orange
        if (cmpo % 2 == 0) {
            if (entity.getOx() < 36 + 1 || entity.getOx() >= 36 * 7) {
                vxo = vxo * -1;
            }
            entity.setOx(entity.getOx() + vxo);

            cmpo++;
            p.repaint();
        } else {
            if (entity.getOy() < 36 + 1 | entity.getOy() >= 36 * 7 - 1) {
                vyo = vyo * -1;
            }
            entity.setOy(entity.getOy() + vyo);

            cmpo++;

            p.repaint();
        }

        p.getGame().checkLife(); // Non optimiser
    }}
}
