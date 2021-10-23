package fr.upec.pacman;

import java.awt.*;

public class Game {
    private GameMap map;
    private Pacman pacman;
    private GameView p;

    public Game(GameView p) {
        this.map = new GameMap();
        this.pacman = new Pacman(5 * 36, 4 * 36, Color.decode("#fdff00"));
        this.p = p;
    }

    public GameMap getMap() {
        return map;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public boolean checkLife() {
        try {    //                                                                                                                                                                                                                                                                             y                                               x
            return p.getGame().getPacman().loseLife(p.getEntity().tabx()[3], p.getEntity().taby()[3], p.getEntity().tabx()[2], p.getEntity().taby()[2], p.getEntity().tabx()[1], p.getEntity().taby()[1], p.getEntity().tabx()[0], p.getEntity().taby()[0], p.getGame().getMap().getPacmanCoords()[0] * 36, p.getGame().getMap().getPacmanCoords()[1] * 36, this);

        } catch (Exception e) {
        }
        return false;
    }

    public boolean win() {
        if (pacman.isAlive() && pacman.getScore() >= 7900) return true;
        else return false;
    }

    public boolean lose() {
        if (pacman.isAlive()) {
            return false;
        } else return true;
    }

    /*   public void restart () {
       Scanner s = new Scanner (System.in) ;
       System.out.println("Voulez vous refaire la partie ? \n   1- Oui  2- Non");
       int choix = s.nextInt() ;
       p.getFrame().dispose();
       if (choix == 1 ) {  App partie = new App () ; partie.main(null);}
    }*/
    public GameView getview() {
        return p;
    }
}
