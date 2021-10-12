package fr.upec.pacman;

import java.awt.*;

public class Pacman {
	private int life;
	private int score;
	private int x ;
	private int y ;
	private Game game;
	private Color color;
	
	public Pacman(Game game) {
		 // Le pacman a 3 vie 0 experience. Il se situe au milieu du terrain
		this.life = 3;
		this.score = 0;
		this.x = 100;
		this.y = 50;
		this.game = game;
		this.color = Color.YELLOW;
	}

	public int getScore() {
		return score;
	}

	public int getLife() {
		return life;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void loseLife(){
		this.life--;
	}

	public void gainLife(){
		this.life++;
	}

	public void eatClassic(){
		score += 100;
		color = Color.YELLOW;
		game.getMap().deleteType(x/36, y/36);
		game.getView().repaint();
	}

	public void eatInvisible(){
		score += 300;
		color = Color.decode("#FDFD96");
		game.getMap().deleteType(x/36, y/36);
		game.getView().repaint();
	}

	public void eatSuperPow(){
		score += 500;
		color = Color.ORANGE;
		game.getMap().deleteType(x/36, y/36);
		game.getView().repaint();
	}

	public void eatMix(){
		score += 1000;
		game.getMap().deleteType(x/36, y/36);
		game.getView().repaint();
	}
}
