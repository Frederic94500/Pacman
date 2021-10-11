package fr.upec.pacman;

public class Game {
    private GameMap map;
    private Pacman pacman;
    private GameView view;
    private Pacmove move;

    public Game() {
        this.map = new GameMap();
        this.pacman = new Pacman();
        this.view = new GameView(this);
        this.move = new Pacmove();
    }

    public GameMap getMap() {
        return map;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public GameView getView() {
        return view;
    }

    public Pacmove getMove() {
        return move;
    }
}
