package fr.upec.pacman;

public class Game {
    private GameMap map;
    private Pacman pacman;
    private GameView p;

    public Game(GameView p) {
        this.map = new GameMap();
        this.pacman = new Pacman();
        this.p = p;
    }

    public GameMap getMap() {
        return map;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void checkLife() {
        Ghost[] ghosts = p.getGhosts();
        for (Ghost g : ghosts) {
            pacman.loseLife(new int[]{g.getX(), g.getY()}, map.getPacmanCoords());
        }
    }

    public boolean win() {
        if (/*pacman.isAlive() &&*/ pacman.getScore() >= 7900) return true;
        else return false;
    }

    public boolean lose() {
        if (!pacman.isAlive()) return false;
        else return true;
    }
}
