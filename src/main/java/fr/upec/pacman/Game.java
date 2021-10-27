package fr.upec.pacman;

import java.awt.*;

public class Game {
    private final int size = 36;
    private GameMap map;
    private Pacman pacman;
    private Ghost[] ghosts;
    private int score;
    private int ateGum;
    private GameView p;

    public Game(GameView p) {
        this.map = new GameMap();
        this.pacman = new Pacman(5 * 36, 4 * 36, this);
        this.ghosts = new Ghost[]{
                new Ghost(size * 2, size * 7, Color.decode("#ea82e5")), //Blue
                new Ghost(size * 7, size * 2, Color.decode("#46bfee")), //Red
                new Ghost(size * 2, size * 2, Color.decode("#db851c")), //Purple
                new Ghost(size * 5, size * 7, Color.decode("#d03e19"))};//Orange
        this.p = p;
        this.score = 0;
        this.ateGum = 0;
    }

    public int getScore() {
        return score;
    }

    public void gainOneUp() {
        if (score % 5000 == 0 && score != 0 && !pacman.isLifeTake()) {
            pacman.oneUp();
            pacman.setLifeTake(true);
        }
        if (score % 5000 != 0 && score != 0 && pacman.isLifeTake()) {
            pacman.setLifeTake(false);
        }
    }

    public void addScore(int score) {
        this.score += score;
    }

    public GameMap getMap() {
        return map;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public Ghost[] getGhosts() {
        return ghosts;
    }

    public boolean checkLife() {
        //                                                                                                                                                                                        y                                               x
        return pacman.loseLife(ghosts[0].getX(), ghosts[0].getY(), ghosts[1].getX(), ghosts[1].getY(), ghosts[2].getX(), ghosts[2].getY(), ghosts[3].getX(), ghosts[3].getY(), getMap().getPacmanCoords()[0] * 36, getMap().getPacmanCoords()[1] * 36);
    }

    public boolean win() {
        if (pacman.isAlive() && ateGum == 99) return true; //changement vers un compteur à pacgum
        else return false;
    }

    public void incrementAteGum() {
        ateGum++;
    }

    /*   public void restart () {
       Scanner s = new Scanner (System.in) ;
       System.out.println("Voulez vous refaire la partie ? \n   1- Oui  2- Non");
       int choix = s.nextInt() ;
       p.getFrame().dispose();
       if (choix == 1 ) {  App partie = new App () ; partie.main(null);}
    }*/
}
