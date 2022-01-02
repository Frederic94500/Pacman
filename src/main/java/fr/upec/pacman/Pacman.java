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

    public Pacman(Game game) {
        super(8 * 36, 11 * 36, 0, 0, Direction.VOID, new ImageSet().getTab(4));
        this.game = game;
        this.life = 3;
        this.alive = true;
        this.invisible = false;
        this.invisibleTimer = 0;
        this.superPow = false;
        this.superPowTimer = 0;
        this.lifeTake = false;
        super.setMypic(1);
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
                    game.getPacman().setTab(new ImageSet().getTab(6)); // Etat du Pacman
                    invisibleTimer = System.currentTimeMillis() - start;
                }
                invisible = false;
                invisibleTimer = 0;
                game.getPacman().setTab(new ImageSet().getTab(4)); // Etat du Pacman
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
                game.getP().getTimerGhost().setDelay(80);
                long start = System.currentTimeMillis();
                for (Ghost g : game.getGhosts()) {
                    g.setImg(new ImageSet().getTab(5));;
                }
                while (!Thread.interrupted()) {
                    superPow = true;
                    game.getPacman().setTab(new ImageSet().getTab(7));  // Etat du Pacman
                    superPowTimer = System.currentTimeMillis() - start;
                }
                game.getP().getTimerGhost().setDelay(40);
                superPow = false;
                superPowTimer = 0;
                game.getPacman().setTab(new ImageSet().getTab(4));  // Etat du Pacman
                for (int i = 0 ; i < game.getGhosts().length ; i++) {
                	game.getGhosts()[i].setImg(new ImageSet().getTab(i));
                }
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

    protected void setTab(Image [] etat) {
		super.setImg(etat);
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
