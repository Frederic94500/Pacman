package fr.upec.pacman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyAction implements ActionListener {
    private Ghost[] ghosts;
    private GameView p;

    public EnemyAction(Ghost[] ghosts, GameView p) {
        this.ghosts = ghosts;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Essai d'implémentation de mouvement aléatoire via les murs c'est buggé!
        for (Ghost g : this.ghosts) {
            while (true) {
                if (p.getGame().getMap().getMap()[(g.getY() + g.getDy()) / 36][(g.getX() + g.getDx()) / 36] == Type.W ||
                        p.getGame().getMap().getMap()[(g.getY() + g.getDy() + 36) / 36][(g.getX() + g.getDx() + 36) / 36] == Type.W) { //si gcoords = mur alors random move
                    g.randomMove();
                } else {
                    g.setX(g.getX() + g.getDx());
                    g.setY(g.getY() + g.getDy());
                    break;
                }
            }
        }
        p.repaint();
        checkLife();
    }

    private void checkLife() {
        if (p.getGame().checkLife()) {
            try {
                for (Ghost g : ghosts) {
                    g.setCounter(0);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
            }
        }
    }
}

