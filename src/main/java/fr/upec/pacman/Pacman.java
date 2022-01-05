package fr.upec.pacman;

import fr.upec.pacman.EntityState.NormalPacman;

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

    public Pacman(Game game) {
        super(8 * 36, 11 * 36, Direction.VOID, Color.decode("#fdff00"), new NormalPacman());
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

    public boolean checkCollision() {
        int pacX = getX();
        int pacY = getY();

        if (!invisible) {
            for (Ghost ghost : game.getGhosts()) {
                int gX = ghost.getX();
                int gY = ghost.getY();
                if ((gX / 36 == pacX / 36 && gY / 36 == pacY / 36) ||
                        (gX / 36 == (pacX) / 36 && gY / 36 == (pacY + 35) / 36) ||
                        (gX / 36 == (pacX + 35) / 36 && gY / 36 == (pacY) / 36) ||
                        (gX / 36 == (pacX + 35) / 36 && gY / 36 == (pacY + 35) / 36)) {
                    if (superPow) {
                        superPow(ghost);
                        return false;
                    } else {
                        life--;
                        setX(8 * 36);
                        setY(11 * 36);
                        for (Ghost g : game.getGhosts()) {
                            g.setX(36 * 8);
                            g.setY(36 * 7);
                        }

                        if (life <= 0) {
                            setAlive(false);
                        }
                        return true;
                    }
                }
            }
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
                game.getP().getTimerGhost().setDelay(60);
                long start = System.currentTimeMillis();
                for (Ghost g : game.getGhosts()) {
                    g.setColor(Color.BLUE);
                }
                while (!Thread.interrupted()) {
                    superPow = true;
                    setColor(Color.ORANGE);
                    superPowTimer = System.currentTimeMillis() - start;
                }
                game.getP().getTimerGhost().setDelay(20);
                superPow = false;
                superPowTimer = 0;
                setColor(Color.decode("#fdff00"));
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

    public long getSuperPowTimer() {
        return superPowTimer;
    }

    public void superPow(Ghost g) {
        g.setX(36 * 8);
        g.setY(36 * 7);
    }

    public void eatMix() {
        if (game.getMap().isBlockingWall()) game.getMap().setBlockingWall(false);
        else game.getMap().setBlockingWall(true);
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
