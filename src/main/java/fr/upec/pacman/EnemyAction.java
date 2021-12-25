package fr.upec.pacman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyAction implements ActionListener {
    private Ghost[] ghosts;
    private Game game;
    private GameView p;

    public EnemyAction(Ghost[] ghosts, Game game, GameView p) {
        this.ghosts = ghosts;
        this.game = game;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ghost g : ghosts) {
            wall(g, game.getMap().getMap());
            p.repaint();
            checkLife(); // Verifie si ca touche
        }
    }

    private void checkLife() {
        if (game.getPacman().checkCollision()) {
            try {
                for (Ghost g : ghosts) {
                    g.setCounter(0);
                }
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    //Choix de la trajectoire des fantomes dynamique :
    private void wall(Ghost g, Type[][] map) {
        int x = g.getX();
        int y = g.getY();

        while (map[(g.getY() + g.getDy()) / 36][(g.getX() + g.getDx()) / 36] == Type.W ||
                map[(g.getY() + g.getDy()) / 36][(g.getX() + g.getDx() + 34) / 36] == Type.W ||
                map[(g.getY() + g.getDy() + 34) / 36][(g.getX() + g.getDx()) / 36] == Type.W ||
                map[(g.getY() + g.getDy() + 34) / 36][(g.getX() + g.getDx() + 34) / 36] == Type.W) {
            Direction dir = Direction.random();
            g.setDx(dir.getDX());
            g.setDy(dir.getDY());
        }

        g.setX(g.getX() + g.getDx());
        g.setY(g.getY() + g.getDy());


        /*int calibrateX = 0;
        int calibrateY = 0;
        int r = (int) (Math.random() * 2);

        if (choice) {
            if (g.getDy() > 0) {
                if (y / 36 > 0) calibrateY = 36;
            } else {
                if (y / 36 > 0) calibrateY = -4;
            }
            calibrateX = 0;
        } else {
            if (g.getDx() > 0) {
                if (x / 36 > 0) calibrateX = 36;
            } else {
                if (x / 36 > 0) calibrateX = -4;
            }
            calibrateY = 0;
        }

        if (g.getX() == 0 || g.getX() == 15 * 36) {
            g.setDx(g.getDx() * -1);
            g.setCounter(0);
        }

        if (game.getMap().getMap()[(y + calibrateY) / 36][(x + calibrateX) / 36] == Type.W) {
            if (choice) {
                if (r == 0) {
                    g.setDy(g.getDy() * -1);
                    g.setY(g.getY() + g.getDy() + g.getDy());
                    g.setCounter(g.getCounter() + 2);
                } else {
                    if (g.getX() % 36 == 0 & g.getY() % 36 == 0) g.setTurn(true);
                }
            } else {
                if (r == 0) {
                    g.setDx(g.getDx() * -1);
                    g.setX(g.getX() + g.getDx() + g.getDx());
                    g.setCounter(g.getCounter() + 2);
                } else {
                    if (g.getX() % 36 == 0 & g.getY() % 36 == 0) g.setTurn(false);
                }
            }
            g.setCounter(r * 9);
        } else {
            if (choice) {
                g.setY(g.getY() + g.getDy());
                g.incrementCounter();
                if (g.getCounter() == 27 & g.getY() % 36 == 0) {
                    g.setTurn(true);
                    g.setCounter(r * 9);
                }
            } else {
                g.setX(g.getX() + g.getDx());
                g.incrementCounter();
                if (g.getCounter() == 18 + r * 9 & g.getX() % 36 == 0) {
                    g.setTurn(false);
                    g.setCounter(r * 9);
                }
            }
        }*/
    }
}
