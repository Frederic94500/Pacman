package fr.upec.pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PacMove implements KeyListener {
    private GameView view;
    private Pacman pacman;

    public PacMove(GameView view, Pacman pacman) {
        this.view = view;
        this.pacman = pacman;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int[] pacmanCoordsMap = view.getGame().getMap().getPacmanCoords();
        Type[][] map = view.getGame().getMap().getMap();
        pacman.setDx(0);
        pacman.setDy(0);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:  //y                         //x
                pacman.setDx(-4);
                if (pacmanCoordsMap[0] == 4 & pacmanCoordsMap[1] == 0) {
                    pacman.setDx(pacman.getDx());
                    map[4][0] = Type.N;
                    map[4][15] = Type.P;
                } else {
                    makeMove(0, -1);
                }
                break;
            case KeyEvent.VK_RIGHT:
                pacman.setDx(4);
                if (pacmanCoordsMap[0] == 4 & pacmanCoordsMap[1] == 15) {
                    map[4][15] = Type.N;
                    map[4][0] = Type.P;
                } else {
                    makeMove(0, 1);
                }
                break;
            case KeyEvent.VK_DOWN:
                pacman.setDy(4);
                makeMove(1, 0);
                break;
            case KeyEvent.VK_UP:
                pacman.setDy(-4);
                makeMove(-1, 0);
                break;
        }
        view.getGame().gainOneUp(); // Verifie s'il a 5000pts pour ajouter une vie en plus.
        view.repaint();
    }

    public void makeMove(int dx, int dy) {
        int[] pacmanCoordsMap = view.getGame().getMap().getPacmanCoords();
        Type[][] map = view.getGame().getMap().getMap();

        if (map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy] != Type.W) {
            switch (map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy]) {
                case C:
                    view.getGame().addScore(100);
                    view.getGame().incrementAteGum();
                    break;
                case I:
                    view.getGame().addScore(300);
                    view.getGame().getPacman().eatInvisible();
                    view.getGame().incrementAteGum();
                    break;
                case S:
                    view.getGame().addScore(500);
                    view.getGame().getPacman().eatSuperPow();
                    view.getGame().incrementAteGum();
                    break;
                case M:
                    view.getGame().addScore(1000);
                    view.getGame().incrementAteGum();
                    break;
                default:
                    break;
            }

            map[pacmanCoordsMap[0]][pacmanCoordsMap[1]] = Type.N;
            map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy] = Type.P;
        }
    }
}
