package fr.upec.pacman;

public class Pacman {

	
	private int vie ; 
	private int points ;
	private int x ;
	private int y ; 
	
	public Pacman () {
		 // Le pacman a 3 vie 0 experience. Il se situe au milieu du terrain   	
		setVie(3) ;
		setPoints(0) ;
		setX(100) ;
		setY(50) ;	
	}

	
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
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
	
	
	
	
}
