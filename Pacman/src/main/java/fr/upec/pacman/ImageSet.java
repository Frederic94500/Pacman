package fr.upec.pacman;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @deprecated image interdite
 */
public class ImageSet {
	// Contient les elements graphics du jeux :
	
	  private Image heart ;
	  private int hx ;
	  private int hy ;
	  
	  private Image GhostBlue ;
	  private int bx ;
	  private int by ;
	  
	  private Image GhostRed ;
	  private int rx ;
	  private int ry ;
	  
	  private Image GhostPurple;
	  private int px ;
	  private int py ;
	  
	  private Image GhostOrange ;
	  private int ox ;
	  private int oy ;
	  
	  private Image Pacman ;
	  private int pacx ;
	  private int pacy ;
	  
	  
	  public ImageSet () {
		  setHeart(new ImageIcon ("res/Heart.png").getImage());
		  setGhostBlue(new ImageIcon ("res/Ghostblue.png").getImage());
		  setGhostRed(new ImageIcon ("res/GhostRed.png").getImage());
		  setGhostPurple(new ImageIcon ("res/GhostPurple.png").getImage());
		  setGhostOrange(new ImageIcon ("res/GhostOrange.png").getImage());
		  setPacman(new ImageIcon ("res/PacRight.png").getImage());
		  
	  }


	public Image getHeart() {
		return heart;
	}


	public void setHeart(Image heart) {
		this.heart = heart;
	}


	public Image getGhostBlue() {
		return GhostBlue;
	}


	public void setGhostBlue(Image ghostBlue) {
		GhostBlue = ghostBlue;
	}


	public Image getGhostRed() {
		return GhostRed;
	}


	public void setGhostRed(Image ghostRed) {
		GhostRed = ghostRed;
	}


	public Image getGhostPurple() {
		return GhostPurple;
	}


	public void setGhostPurple(Image ghostPurple) {
		GhostPurple = ghostPurple;
	}


	public Image getGhostOrange() {
		return GhostOrange;
	}


	public void setGhostOrange(Image ghostOrange) {
		GhostOrange = ghostOrange;
	}


	public Image getPacman() {
		return Pacman;
	}


	public void setPacman(Image pacman) {
		Pacman = pacman;
	}


	public int getHx() {
		return hx;
	}


	public void setHx(int hx) {
		this.hx = hx;
	}


	public int getHy() {
		return hy;
	}


	public void setHy(int hy) {
		this.hy = hy;
	}


	public int getBx() {
		return bx;
	}


	public void setBx(int bx) {
		this.bx = bx;
	}


	public int getBy() {
		return by;
	}


	public void setBy(int by) {
		this.by = by;
	}


	public int getRx() {
		return rx;
	}


	public void setRx(int rx) {
		this.rx = rx;
	}


	public int getRy() {
		return ry;
	}


	public void setRy(int ry) {
		this.ry = ry;
	}


	public int getPx() {
		return px;
	}


	public void setPx(int px) {
		this.px = px;
	}


	public int getPy() {
		return py;
	}


	public void setPy(int py) {
		this.py = py;
	}


	public int getOx() {
		return ox;
	}


	public void setOx(int ox) {
		this.ox = ox;
	}


	public int getOy() {
		return oy;
	}


	public void setOy(int oy) {
		this.oy = oy;
	}


	public int getPacx() {
		return pacx;
	}


	public void setPacx(int pacx) {
		this.pacx = pacx;
	}


	public int getPacy() {
		return pacy;
	}


	public void setPacy(int pacy) {
		this.pacy = pacy;
	}

	
}
