package fr.upec.pacman;

public class Pacman {
	private int life;
	private int score;
	private int x ;
	private int y ;
	private Game game;
	
	public Pacman(Game game) {
		 // Le pacman a 3 vie 0 experience. Il se situe au milieu du terrain
		this.life = 3;
		this.score = 0;
		this.x = 100;
		this.y = 50;
		this.game = game;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void eatClassic(){
		score += 100;
		game.getMap().deleteType(x/36, y/36);
		game.getView().repaint();
	}

	public void eatInvisible(){
		score += 300;
		game.getMap().deleteType(x/36, y/36);
		game.getView().repaint();
	}

	public void eatSuperPow(){
		score += 500;
		game.getMap().deleteType(x/36, y/36);
		game.getView().repaint();
	}

	public void eatMix(){
		score += 1000;
		game.getMap().deleteType(x/36, y/36);
		game.getView().repaint();
	}
}
