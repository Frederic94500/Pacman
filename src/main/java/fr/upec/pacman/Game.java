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
       try {
    	p.getGame().getPacman().loseLife(p.getEntity().getRx(), p.getEntity().getBx(), p.getEntity().getPx(), p.getEntity().getOx(), p.getGame().getMap().getPacmanCoords()[0] * 36);
    }catch (Exception e) {}}

    public boolean win() {
        if (/*pacman.isAlive() &&*/ pacman.getScore() >= 7900) return true;
        else return false;
    }
    public boolean lose() {
        if (!pacman.isAlive()) return false;
        else return true;
    }
}
