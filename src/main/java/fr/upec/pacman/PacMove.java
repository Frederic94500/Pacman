package fr.upec.pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PacMove implements KeyListener {
    private GameView view;

    public PacMove(GameView view) {
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
        int[] pacmanCoordsMap = view.getGame().getMap().getPacmanCoords();
        Type[][] map = view.getGame().getMap().getMap();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:  //y                         //x
                if (pacmanCoordsMap[0] == 4 & pacmanCoordsMap[1] == 0) {
                    map[4][0] = Type.N;
                    map[4][9] = Type.P;
                } else {
                    makeMove(0, -1);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (pacmanCoordsMap[0] == 4 & pacmanCoordsMap[1] == 9) {
                    map[4][9] = Type.N;
                    map[4][0] = Type.P;
                } else {
                    makeMove(0, 1);
                }
                break;
            case KeyEvent.VK_DOWN:
                makeMove(1, 0);
                break;
            case KeyEvent.VK_UP:
                makeMove(-1, 0);
                break;
        }
        view.getGame().getPacman().setLife(0); // Verifie s'il a 5000pts pour ajouter une vie en plus.
        view.repaint();

    }

    public void makeMove(int dx, int dy) {
        int[] pacmanCoordsMap = view.getGame().getMap().getPacmanCoords();
        Type[][] map = view.getGame().getMap().getMap();

        if (map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy] != Type.W) {

            switch (map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy]) {
                case C:
                    view.getGame().getPacman().addScore(100);
                    view.getGame().getPacman().setPacgum(view.getGame().getPacman().getPacgum() + 1);
                    break;
                case I:
                    view.getGame().getPacman().addScore(300);
                    view.getGame().getPacman().setPacgum(view.getGame().getPacman().getPacgum() + 1);
                    break;
                case S:
                    view.getGame().getPacman().addScore(500);
                    view.getGame().getPacman().setPacgum(view.getGame().getPacman().getPacgum() + 1);
                    break;
                case M:
                    view.getGame().getPacman().addScore(1000);
                    view.getGame().getPacman().setPacgum(view.getGame().getPacman().getPacgum() + 1);
                    break;
                default:
                    break;
            }

            map[pacmanCoordsMap[0]][pacmanCoordsMap[1]] = Type.N;
            map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy] = Type.P;
        }
    }
}
