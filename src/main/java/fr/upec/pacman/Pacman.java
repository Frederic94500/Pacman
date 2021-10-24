package fr.upec.pacman;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pacman extends Entity {
    private float life;
    private int score;
    private boolean alive;
    private boolean invisible;
    private boolean superPow;

    public Pacman(int x, int y, Color color) {
        super(x, y, color);
        // Le pacman a 3 vie 0 experience. Il se situe au milieu du terrain
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
            this.life += 1; //Il y a un bug assez bizarre... Quand on appuie sur gauche, il y a des vies en plus qui apparaissent
        }
    }

    public boolean loseLife(int bx, int by, int rx, int ry, int px, int py, int ox, int oy, int pacy, int pacx, Game game) {
        if (((pacx == px && pacy == py) || (pacx == rx && pacy == ry) || (pacx == bx && pacy == by) || (pacx == ox && pacy == oy)) && !invisible) {
            life--;
            game.getMap().setPacmanCoords(new int[]{8, 8});
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
