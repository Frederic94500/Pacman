package fr.upec.pacman;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @deprecated image interdite
 */
public class ImageSet {
	// Contient les elements graphics du jeux :
	  // bx rx px ox 
	  private int [] tabx = new int [4]; 
	  private int [] taby = new int [4]; 
	  private Image GhostBlue ;
	  private Image GhostRed ;
	  private Image GhostPurple;
	  private Image GhostOrange ;
	  private Image Pacman ;

	  
	  public ImageSet () { 
		  setGhostBlue(new ImageIcon ("res/Ghostblue.png").getImage());
		  setGhostRed(new ImageIcon ("res/GhostRed.png").getImage());
		  setGhostPurple(new ImageIcon ("res/GhostPurple.png").getImage());
		  setGhostOrange(new ImageIcon ("res/GhostOrange.png").getImage());
		  setPacman(new ImageIcon ("res/PacRight.png").getImage());
	      set () ;
	  }


	public int [] tabx () {return this.tabx;}
	public int [] taby () {return this.taby;}

	
	
	
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

	public void set () {
		tabx [0]=36*8; taby [0]=36*5; 
		tabx [1]=36*2; taby [1]=36*2; 
		tabx [2]=36*2; taby [2]=36*7; 
		tabx [3]=36*8; taby [3]=36*2; 
	}
	public void set2 () {
		tabx [0]=36*2; taby [0]=36*3; 
		tabx [1]=36*2; taby [1]=36*2; 
		tabx [2]=36*2; taby [2]=36*7; 
		tabx [3]=36*3; taby [3]=36*7; 

	}

}
