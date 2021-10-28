package fr.upec.pacman;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pacman extends Entity {
    private Game game;
    private int life;
    private boolean alive;
    private boolean invisible;
    private long invisibleTimer;
    private boolean superPow;
    private long superPowTimer;
    private boolean lifeTake;

    public Pacman(int x, int y, Game game) {
        super(x, y, Color.decode("#fdff00"));
        this.game = game;
        this.life = 3;
        this.alive = true;
        this.invisible = false;
        this.invisibleTimer = 0;
        this.superPow = false;
        this.superPowTimer = 0;
        this.lifeTake = false;
    }

    public int getLife() {
        return life;
    }

    public void oneUp() {
        this.life++;
    }

    public boolean loseLife(int bx, int by, int rx, int ry, int px, int py, int ox, int oy, int pacy, int pacx) {
        int i = 0 ;
    	if (((pacx == px && pacy == py) || (pacx == rx && pacy == ry) || (pacx == bx && pacy == by) || (pacx == ox && pacy == oy)) && !invisible && !superPow) {
            life--;
            int[] oldPacCoords = game.getMap().getPacmanCoords();
            game.getMap().setPacmanCoords(5, 13);
            game.getMap().delete(oldPacCoords[0], oldPacCoords[1]);
            for (Ghost g : game.getGhosts()) {
                g.setX(72);
                g.setY(72 + i);
                i+=36;
            }

            if (life <= 0) {
                setAlive(false);
            }
            return true;
        }
        return false;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void eatInvisible() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Future future = executor.submit(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                while (!Thread.interrupted()) {
                    invisible = true;
                    setColor(Color.decode("#FDFD96"));
                    invisibleTimer = System.currentTimeMillis() - start;
                }
                invisible = false;
                invisibleTimer = 0;
                setColor(Color.decode("#fdff00"));
            }
        });
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                future.cancel(true);
            }
        }, 10, TimeUnit.SECONDS);
        executor.shutdown();
    }

    public long getInvisibleTimer() {
        return invisibleTimer;
    }

    public boolean isSuperPow() {
        return superPow;
    }

    public void eatSuperPow() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Future future = executor.submit(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                while (!Thread.interrupted()) {
                    superPow = true;
                    setColor(Color.ORANGE);
                    for (Ghost g : game.getGhosts()) {
                        g.setColor(Color.BLUE);
                        superPow(g);
                       // g.setDx(3); //Rend les Ghosts buggé (voir EnemyAction (mauvaise implémentation))
                       // g.setDy(3);
                    }
                    superPowTimer = System.currentTimeMillis() - start;
                }
                superPow = false;
                superPowTimer = 0;
                setColor(Color.decode("#fdff00"));
                game.getGhosts()[0].setColor(Color.decode("#ea82e5"));
                game.getGhosts()[1].setColor(Color.decode("#46bfee"));
                game.getGhosts()[2].setColor(Color.decode("#db851c"));
                game.getGhosts()[3].setColor(Color.decode("#d03e19"));
               /* for (Ghost g : game.getGhosts()) {
                    g.setDx(4); //Rend les Ghosts buggé (voir EnemyAction (mauvaise implémentation))
                    g.setDy(4);
                }*/
            }
        });
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                future.cancel(true);
            }
        }, 10, TimeUnit.SECONDS);
        executor.shutdown();
    }

    public long getSuperPowTimer() {
        return superPowTimer;
    }

    public void superPow(Ghost g) {
        if (g.getX() == game.getMap().getPacmanCoords()[1] * 36 && g.getY() == game.getMap().getPacmanCoords()[0] * 36) {
            g.setX(72);
            g.setY(72);
        }
    }

    public void eatMix() {

    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isLifeTake() {
        return lifeTake;
    }

    public void setLifeTake(boolean lifeTake) {
        this.lifeTake = lifeTake;
    }
}
