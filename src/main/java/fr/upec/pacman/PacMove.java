package fr.upec.pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PacMove implements KeyListener {
    private Game game;
    private GameView view;

    public PacMove(Game game, GameView view) {
        this.game = game;
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        view.setEat(false);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (!game.win() || !game.getPacman().isAlive()) {
                    game.getPacman().setDx(Direction.LEFT.getDX());
                    game.getPacman().setDy(Direction.LEFT.getDY());
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!game.win() || !game.getPacman().isAlive()) {
                    game.getPacman().setDx(Direction.RIGHT.getDX());
                    game.getPacman().setDy(Direction.RIGHT.getDY());
                }
                break;
            case KeyEvent.VK_UP:
                if (!game.win() || !game.getPacman().isAlive()) {
                    game.getPacman().setDx(Direction.UP.getDX());
                    game.getPacman().setDy(Direction.UP.getDY());
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!game.win() || !game.getPacman().isAlive()) {
                    game.getPacman().setDx(Direction.DOWN.getDX());
                    game.getPacman().setDy(Direction.DOWN.getDY());
                }
                break;
            case KeyEvent.VK_SPACE:
                if (game.getPacman().isAlive()) {
                    view.setStart(true);
                } else {
                    view.getFrame().dispose();
                    App.main(null);
                }
                if (game.win()) {
                    view.getFrame().dispose();
                    App.main(null);
                }
        }

        view.repaint();

        /*if (!game.win() || !game.getPacman().isAlive()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    game.getPacman().setDx(Direction.LEFT.getX());
                    game.getPacman().setDy(Direction.LEFT.getY());
                    break;
                case KeyEvent.VK_RIGHT:
                    game.getPacman().setDx(Direction.RIGHT.getX());
                    game.getPacman().setDy(Direction.RIGHT.getY());
                    break;
                case KeyEvent.VK_UP:
                    game.getPacman().setDx(Direction.UP.getX());
                    game.getPacman().setDy(Direction.UP.getY());
                    break;
                case KeyEvent.VK_DOWN:
                    game.getPacman().setDx(Direction.DOWN.getX());
                    game.getPacman().setDy(Direction.DOWN.getY());
                    break;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (game.getPacman().isAlive()) {
                view.setStart(true);
            } else {
                view.getFrame().dispose();
                App.main(null);
            }
            if (game.win()) {
                view.getFrame().dispose();
                App.main(null);
            }
        }*/
    }
}
