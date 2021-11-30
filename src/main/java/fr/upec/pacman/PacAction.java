package fr.upec.pacman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacAction implements ActionListener {
    private Game game;
    private GameView view;
    private Pacman pacman;

    public PacAction(Game game, GameView view, Pacman pacman) {
        this.game = game;
        this.view = view;
        this.pacman = pacman;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] pacmanCoordsMap = game.getMap().getPacmanCoords();
        Type[][] map = game.getMap().getMap();

        //Warparound à réimplémenter
        if (pacman.getX() / 36 == 0 && pacman.getY() / 36 == 7) {

        }

        if (pacman.getX() / 36 == 16 && pacman.getY() / 36 == 7) {
            map[7][16] = Type.N;
            map[7][0] = Type.P;
        }

        if (pacmanCoordsMap[0] == 7 & pacmanCoordsMap[1] == 0) {
            map[7][0] = Type.N;
            map[7][16] = Type.P;
        }

        if (pacmanCoordsMap[0] == 7 & pacmanCoordsMap[1] == 16) {
            map[7][16] = Type.N;
            map[7][0] = Type.P;
        }

        //Détection des murs et des murs à refaire
        if (map[(pacman.getY() + pacman.getDy()) / 36][(pacman.getX() + pacman.getDx()) / 36] != Type.W &&
                map[(pacman.getY() + pacman.getDy() + 36) / 36][(pacman.getX() + pacman.getDx() + 36) / 36] != Type.W) {
            switch (map[(pacman.getY() + pacman.getDy()) / 36][(pacman.getX() + pacman.getDx()) / 36]) {
                case C:
                    game.addScore(100);
                    view.setScoreGet(100);
                    view.setEat(true);
                    break;
                case I:
                    game.addScore(300);
                    game.getPacman().eatInvisible();
                    view.setScoreGet(300);
                    view.setEat(true);
                    break;
                case S:
                    game.addScore(500);
                    game.getPacman().eatSuperPow();
                    view.setScoreGet(500);
                    view.setEat(true);
                    break;
                case M:
                    game.addScore(1000);
                    game.getPacman().eatMix();
                    view.setScoreGet(1000);
                    view.setEat(true);
                    break;
                case N:
                    view.setEat(false);
                    break;
                default:
                    break;
            }
        }

        game.gainOneUp(); // Verifie s'il a 5000pts pour ajouter une vie en plus.
        map[pacman.getY() / 36][pacman.getX() / 36] = Type.N;
        pacman.setX(pacman.getX() + pacman.getDx());
        pacman.setY(pacman.getY() + pacman.getDy());
        view.repaint();
    }
}
