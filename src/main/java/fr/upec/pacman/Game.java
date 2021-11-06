package fr.upec.pacman;

import java.awt.*;

public class Game {
    private final int size = 36;
    private GameMap map;
    private Pacman pacman;
    private Ghost[] ghosts;
    private GameView p;
    private PacMove pacMove;
    private int score;

    public Game(Frame f) {
        this.map = new GameMap();
        this.pacman = new Pacman(5 * 36, 4 * 36, this);
        this.ghosts = new Ghost[]{
                new Ghost(size * 7, size * 5, Color.decode("#ea82e5")), //Blue
                new Ghost(size * 8, size * 5, Color.decode("#46bfee")), //Red
                new Ghost(size * 9, size * 5, Color.decode("#db851c")), //Purple
                new Ghost(size * 8, size * 9, Color.decode("#d03e19"))};//Orange
        this.p = new GameView(f, this);
        this.pacMove = new PacMove(this, p);
        this.score = 0;
    }

    public PacMove getPacMove() {
        return pacMove;
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

    public GameView getP() {
        return p;
    }

    public boolean checkLife() {
        return pacman.loseLife(ghosts[0].getX(), ghosts[0].getY(),
                ghosts[1].getX(), ghosts[1].getY(),
                ghosts[2].getX(), ghosts[2].getY(),
                ghosts[3].getX(), ghosts[3].getY(),
                getMap().getPacmanCoords()[0] * 36, getMap().getPacmanCoords()[1] * 36);
    }

    public boolean win() {
        return pacman.isAlive() && map.isAllPacGumAte();
    }
}
