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
        Type[][] map = game.getMap().getMap();
        int pacXMove = pacman.getX() + pacman.getDx();
        int pacYMove = pacman.getY() + pacman.getDy();

        //Warparound à réimplémenter (je sais pas comment faire...)
        /*if (pacman.getX() < 0 && pacman.getY() / 36 == 7) {
            pacman.setX(16 * 36);
            //pacman.setY(7 * 36);
        }

        if (pacman.getX() > 0 && pacman.getY() / 36 == 7) {
            pacman.setX(0);
            //pacman.setY(7 * 36);
        }*/

        /*if (pacmanCoordsMap[0] == 7 & pacmanCoordsMap[1] == 0) {
            map[7][0] = Type.N;
            map[7][16] = Type.P;
        }

        if (pacmanCoordsMap[0] == 7 & pacmanCoordsMap[1] == 16) {
            map[7][16] = Type.N;
            map[7][0] = Type.P;
        }*/
    	if (pacXMove == 0  && pacYMove  == 252)  {pacXMove = 572;} 
    	  else {
    	     if (pacXMove == 576 && pacYMove  == 252)  {pacXMove = 4;}
                }

        if (map[(pacYMove) / 36][(pacXMove) / 36] != Type.W &&
                map[(pacYMove) / 34][(pacXMove + 34) / 36] != Type.W &&
                map[(pacYMove + 34) / 36][(pacXMove) / 36] != Type.W &&
                map[(pacYMove + 34) / 36][(pacXMove + 34) / 36] != Type.W) {
            switch (map[(pacYMove) / 36][(pacXMove) / 36]) {
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
            game.gainOneUp(); // Verifie s'il a 5000pts pour ajouter une vie en plus.
            game.getMap().delete(pacman.getY() / 36, pacman.getX() / 36);
            pacman.setX(pacXMove);
            pacman.setY(pacYMove);
        }

        view.repaint();
    }
    
}
