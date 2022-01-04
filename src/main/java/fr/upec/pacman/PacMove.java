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
                    game.getPacman().setDirection(Direction.LEFT);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!game.win() || !game.getPacman().isAlive()) {
                    game.getPacman().setDirection(Direction.RIGHT);
                }
                break;
            case KeyEvent.VK_UP:
                if (!game.win() || !game.getPacman().isAlive()) {
                    game.getPacman().setDirection(Direction.UP);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!game.win() || !game.getPacman().isAlive()) {
                    game.getPacman().setDirection(Direction.DOWN);
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
    }
}
