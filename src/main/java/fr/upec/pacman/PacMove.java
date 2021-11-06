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
        int[] pacmanCoordsMap = game.getMap().getPacmanCoords();
        Type[][] map = game.getMap().getMap();
        view.setEat(false);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:  //y                         //x
                if (!game.win() || !game.getPacman().isAlive()) {
                    if (pacmanCoordsMap[0] == 7 & pacmanCoordsMap[1] == 0) {
                        map[7][0] = Type.N;
                        map[7][16] = Type.P;
                    } else {
                        makeMove(0, -1);
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!game.win() || !game.getPacman().isAlive()) {
                    if (pacmanCoordsMap[0] == 7 & pacmanCoordsMap[1] == 16) {
                        map[7][16] = Type.N;
                        map[7][0] = Type.P;
                    } else {
                        makeMove(0, 1);
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!game.win() || !game.getPacman().isAlive()) {
                    makeMove(1, 0);
                }
                break;
            case KeyEvent.VK_UP:
                if (!game.win() || !game.getPacman().isAlive()) {
                    makeMove(-1, 0);
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
                break;
        }
        game.gainOneUp(); // Verifie s'il a 5000pts pour ajouter une vie en plus.
        view.repaint();
    }

    public void makeMove(int dx, int dy) {
        int[] pacmanCoordsMap = game.getMap().getPacmanCoords();
        Type[][] map = game.getMap().getMap();

        if (map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy] != Type.W) {
            switch (map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy]) {
                case C:
                    game.addScore(100);
                    view.setEat(true);
                    break;
                case I:
                    game.addScore(300);
                    game.getPacman().eatInvisible();
                    break;
                case S:
                    game.addScore(500);
                    game.getPacman().eatSuperPow();
                    break;
                case M:
                    game.addScore(1000);
                    game.getPacman().eatMix();
                    break;
                case N:
                    view.setEat(false);
                    break;
                default:
                    break;
            }

            map[pacmanCoordsMap[0]][pacmanCoordsMap[1]] = Type.N;
            map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy] = Type.P;
        }
    }
}
