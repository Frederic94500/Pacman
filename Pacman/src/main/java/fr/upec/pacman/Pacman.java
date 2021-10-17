package fr.upec.pacman;

public class Pacman {
	private int life;
	private int score;
	private int x ;
	private int y ; 
	
	public Pacman() {
		 // Le pacman a 3 vie 0 experience. Il se situe au milieu du terrain
		this.life = 3;
		this.score = 0;
		this.x = 100;
		this.y = 50;
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

	}

	public void eatInvisible(){

	}

	public void eatSuperPow(){

	}

	public void eatMix(){

	}
}
