package fr.upec.pacman.EntityState;

import fr.upec.pacman.Game;
import fr.upec.pacman.Ghost;
import fr.upec.pacman.Pacman;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SuperPovPacman implements EntityState {
    private Game game;
    private Pacman pacman;

    public SuperPovPacman(Game game, Pacman pacman) {
        this.game = game;
        this.pacman = pacman;
    }

    @Override
    public void colorState() {
        pacman.setColor(Color.ORANGE);
    }

    @Override
    public void state() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Future<?> future = executor.submit(() -> {
            game.getP().getTimerGhost().setDelay(60);
            long start = System.currentTimeMillis();
            for (Ghost g : game.getGhosts()) {
                g.setColor(Color.BLUE);
            }
            while (!Thread.interrupted()) {
                colorState();
                pacman.setSuperPow(true);
                pacman.setSuperPowTimer(System.currentTimeMillis() - start);
            }
            game.getP().getTimerGhost().setDelay(20);
            pacman.setSuperPow(false);
            pacman.setSuperPowTimer(0);

            pacman.setState(new NormalPacman(pacman));
            pacman.getState().state();

            game.getGhosts()[0].setColor(Color.decode("#ea82e5"));
            game.getGhosts()[1].setColor(Color.decode("#46bfee"));
            game.getGhosts()[2].setColor(Color.decode("#db851c"));
            game.getGhosts()[3].setColor(Color.decode("#d03e19"));
        });
        executor.schedule(() -> {
            future.cancel(true);
        }, 10, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
