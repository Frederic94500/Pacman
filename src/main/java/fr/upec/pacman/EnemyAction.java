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
        // rechercher les enemies :
        if (!p.getGame().win()) {

            // Blue
            if (ghosts[0].isTurn()) {
                if (ghosts[0].getX() <= 36 || ghosts[0].getX() >= 36 * 7) {
                    ghosts[0].setVx(ghosts[0].getVx() * -1); // Inverse axe X
                }
                ghosts[0].setX(ghosts[0].getX() + ghosts[0].getVx());
                ghosts[0].incrementCmp();
                p.repaint();
                if (ghosts[0].getCmp() == 12) {
                    ghosts[0].setTurn(false);
                    ghosts[0].setCmp(0);
                }
            } else {
                if (ghosts[0].getY() < 36 + 1 | ghosts[0].getY() >= 36 * 7 - 1) {
                    // Random direction :
                    ghosts[0].setVy(ghosts[0].getVy() * -1);
                }
                ghosts[0].setY(ghosts[0].getY() + ghosts[0].getVy());
                ghosts[0].incrementCmp();
                p.repaint();
                if (ghosts[0].getCmp() == 36) {
                    ghosts[0].setTurn(true);
                    ghosts[0].setCmp(0);
                }
            }

            // Red
            if (ghosts[1].isTurn()) {
                if (ghosts[1].getX() <= 36 || ghosts[1].getX() >= 36 * 7) {
                    ghosts[1].setVx(ghosts[1].getVx() * -1);
                }
                ghosts[1].setX(ghosts[1].getX() + ghosts[1].getVx());
                ghosts[1].incrementCmp();
                p.repaint();
                if (ghosts[1].getCmp() == 24) {
                    ghosts[1].setTurn(false);
                    ghosts[1].setCmp(0);
                }

            } else {
                if (ghosts[1].getY() < 36 + 1 | ghosts[1].getY() >= 36 * 7 - 1) {
                    ghosts[1].setVy(ghosts[1].getVy() * -1);
                }
                ghosts[1].setY(ghosts[1].getY() + ghosts[1].getVy());
                ghosts[1].incrementCmp();
                p.repaint();
                if (ghosts[1].getCmp() == 24) {
                    ghosts[1].setTurn(true);
                    ghosts[1].setCmp(0);
                }

            }

            //Purple
            if (!ghosts[2].isTurn()) {
                if (ghosts[2].getX() <= 36 || ghosts[2].getX() >= 36 * 7) {
                    ghosts[2].setVx(ghosts[2].getVx() * -1);
                }
                ghosts[2].setX(ghosts[2].getX() + ghosts[2].getVx());
                ghosts[2].incrementCmp();
                p.repaint();
                if (ghosts[2].getCmp() == 12) {
                    ghosts[2].setTurn(true);
                    ghosts[2].setCmp(0);
                }
            } else {
                if (ghosts[2].getY() < 36 + 1 | ghosts[2].getY() >= 36 * 7 - 1) {
                    ghosts[2].setVy(ghosts[2].getVy() * -1);
                }
                ghosts[2].setY(ghosts[2].getY() + ghosts[2].getVy());
                ghosts[2].incrementCmp();
                p.repaint();
                if (ghosts[2].getCmp() == 24) {
                    ghosts[2].setTurn(false);
                    ghosts[2].setCmp(0);
                }
            }

            // Orange
            if (!ghosts[3].isTurn()) {
                if (ghosts[3].getX() <= 36 || ghosts[3].getX() >= 36 * 7) {
                    ghosts[3].setVx(ghosts[3].getVx() * -1);
                }
                ghosts[3].setX(ghosts[3].getX() + ghosts[3].getVx());
                ghosts[3].incrementCmp();
                p.repaint();
                if (ghosts[3].getCmp() == 24) {
                    ghosts[3].setTurn(true);
                    ghosts[3].setCmp(0);
                }
            } else {
                if (ghosts[3].getY() < 36 + 1 | ghosts[3].getY() >= 36 * 7 - 1) {
                    ghosts[3].setVy(ghosts[3].getVy() * -1);
                }
                ghosts[3].setY(ghosts[3].getY() + ghosts[3].getVy());
                ghosts[3].incrementCmp();
                p.repaint();
                if (ghosts[3].getCmp() == 36) {
                    ghosts[3].setTurn(false);
                    ghosts[3].setCmp(0);
                }
            }

            // Verifie si ca touche
            if (p.getGame().checkLife()) {
                try {
                    for (Ghost g : this.ghosts) {
                        g.setCmp(0); // On restart le compteur de chaque fantome ssi l'un d'entre eux touche pacman !!
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}

