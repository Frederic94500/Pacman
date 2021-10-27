package fr.upec.pacman;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pacman extends Entity {
    private Game game;
    private float life;
    private int score;
    private boolean alive;
    private boolean invisible;
    private boolean superPow;

    public Pacman(int x, int y, Game game) {
        super(x, y, Color.decode("#fdff00"));
        this.game = game;
        this.life = 3;
        this.score = 0;
        this.alive = true;
        this.invisible = false;
        this.superPow = false;
    }

    public int getScore() {
        return score;
    }

    public float getLife() {
        return life;
    }

    public void setLife() {
        if (score % 5000 == 0) {
            this.life += 1;
        }
    }

    public boolean loseLife(int bx, int by, int rx, int ry, int px, int py, int ox, int oy, int pacy, int pacx) {
        if (((pacx == px && pacy == py) || (pacx == rx && pacy == ry) || (pacx == bx && pacy == by) || (pacx == ox && pacy == oy)) && !invisible && !superPow) {
            life--;
            game.getMap().setPacmanCoords(8, 8);
            for (Ghost g : game.getGhosts()) {
                g.setX(72);
                g.setY(72);
            }

            if (life <= 0) {
                setAlive(false);
            }
            return true;
        }
        return false;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void eatInvisible() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Future future = executor.submit(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    invisible = true;
                    setColor(Color.decode("#FDFD96"));
                }
                invisible = false;
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

    public void eatSuperPow() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Future future = executor.submit(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    superPow = true;
                    setColor(Color.ORANGE);
                    for (Ghost g : game.getGhosts()) {
                        g.setColor(Color.BLUE);
                        superPow(g);
                    }
                }
                superPow = false;
                setColor(Color.ORANGE);
                game.getGhosts()[0].setColor(Color.decode("#ea82e5"));
                game.getGhosts()[1].setColor(Color.decode("#46bfee"));
                game.getGhosts()[2].setColor(Color.decode("#db851c"));
                game.getGhosts()[3].setColor(Color.decode("#d03e19"));
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
}
