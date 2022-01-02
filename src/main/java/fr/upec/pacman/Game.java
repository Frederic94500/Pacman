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
    private ImageSet setpic;

    public Game(Frame f) {
        this.map = new GameMap();
        this.setpic = new ImageSet();
        this.pacman = new Pacman(this);
        this.ghosts = new Ghost[]{
                new Ghost(size * 7, size * 5, setpic.getTab(0)), //Blue
                new Ghost(size * 8, size * 5, setpic.getTab(1)), //Red
                new Ghost(size * 9, size * 5, setpic.getTab(2)), //Purple
                new Ghost(size * 8, size * 9, setpic.getTab(3))};//Orange
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

    public void gainOneUp() {
        if (score % 5000 == 0 && score != 0 && !pacman.isLifeTake()) {
            pacman.oneUp();
            pacman.setLifeTake(true);
        }
        if (score % 5000 != 0 && score != 0 && pacman.isLifeTake()) {
            pacman.setLifeTake(false);
        }
    }

    public boolean win() {
        return pacman.isAlive() && map.isAllPacGumAte();
    }
}
