package fr.upec.pacman;

public class Game {
    private GameMap map;
    private Pacman pacman;

    public Game() {
        this.map = new GameMap();
        this.pacman = new Pacman();
    }

    public GameMap getMap() {
        return map;
    }

    public Pacman getPacman() {
        return pacman;
    }

}
