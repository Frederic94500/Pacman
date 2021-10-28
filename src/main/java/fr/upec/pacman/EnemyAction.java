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
        for (Ghost g : ghosts) {
            if (g.isTurn()) {
                // Axe des X
                wall(g, false);
                g.setX(g.getX() + g.getDx());
                g.incrementCounter();
                if (g.getCounter() == 18) {
                    g.setTurn(false);
                    g.setCounter(0);
                }
            } else {
                // Axe des y
                wall(g, true);
                g.setY(g.getY() + g.getDy());
                g.incrementCounter();
                if (g.getCounter() == 27) {
                    g.setTurn(true);
                    g.setCounter(0);
                }
            }
            p.repaint();
            checkLife(); // Verifie si ca touche
        }
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

    //Ce code est totalement lié par la map
    private void wall(Ghost g, boolean choice) {
        int x = g.getX();
        int y = g.getY();
        if (choice) {
            if (y == 36) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 8 * 36 & g.getDy() > 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 3 * 36 & x == 4 * 36 && g.getDy() < 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 4 * 36 & (x == 4 * 36 || x == 3 * 36) && g.getDy() > 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 6 * 36 & (x == 4 * 36 || x == 3 * 36) && g.getDy() < 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 6 * 36 & (x == 6 * 36 || x == 7 * 36 || x == 8 * 36) & g.getDy() > 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 8 * 36 & x == 8 * 36 & g.getDy() < 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 8 * 36 & x == 6 * 36 & g.getDy() < 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 3 * 36 & (x == 12 * 36 || x == 10 * 36) & g.getDy() > 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 7 * 36 & x == 12 * 36 & g.getDy() < 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 2 * 36 & x == 11 * 36 & g.getDy() > 0) {
                g.setDy(g.getDy() * -1);
            }
            if (y == 5 * 36 & (x == 11 * 36 || x == 10 * 36) & g.getDy() < 0) {
                g.setDy(g.getDy() * -1);
            }
        }
        // X
        else {
            if (x == 36) {
                g.setDx(g.getDx() * -1);
            }
            if (x == 14 * 36) {
                g.setDx(g.getDx() * -1);
            }
            if (x == 3 * 36 & (y == 36 || y == 2 * 36) & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (x == 5 * 36 & (y == 36 || y == 2 * 36) & g.getDx() < 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 5 * 36 & (x == 36 * 2) & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 5 * 36 & (x == 36 * 5) & g.getDx() < 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 7 * 36 & x == 5 * 36 & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 7 * 36 & x == 9 * 36 & g.getDx() < 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 8 * 36 & x == 6 * 36 & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 8 * 36 & x == 8 * 36 & g.getDx() < 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 4 * 36 & x == 9 * 36 & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 4 * 36 & x == 13 * 36 & g.getDx() < 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 5 * 36 & x == 13 * 36 & g.getDx() < 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 6 * 36 & x == 13 * 36 & g.getDx() < 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 4 * 36 & x == 11 * 36 & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 5 * 36 & x == 11 * 36 & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 6 * 36 & x == 11 * 36 & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 3 * 36 & x == 10 * 36 & g.getDx() > 0) {
                g.setDx(g.getDx() * -1);
            }
            if (y == 3 * 36 & x == 112 * 36 & g.getDx() < 0) {
                g.setDx(g.getDx() * -1);
            }
        }
    }
}




