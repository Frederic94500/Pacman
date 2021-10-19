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
        p.getGame().getPacman().loseLife(p.getEntity().getRx(), p.getEntity().getBx(), p.getEntity().getPx(), p.getEntity().getOx(), p.getGame().getMap().getPacmanCoords()[1] * 36);

    }
    /*
    public boolean win() {
    	if (pacman.isAlive() && pacman.getPacgomme() == 64) {
    		System.out.println("YOU WIN");
    		return true ;
    	} 
    	    return false ;
    }*/
}
