package fr.upec.pacman;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageSet {
	
	  private Image[] blue;
	  private Image[] red;
	  private Image[] purple;
	  private Image[] orange;
	  private Image[] pacpic ;
	  private Image[] pacinv ;
	  private Image[] pacsup ;
	  private Image[] freeze;
	  
	  public ImageSet () {
		  blue  = new Image[4];
		  red   = new Image[4];
		  purple= new Image[4];
		  orange= new Image[4];
		  pacpic= new Image[4];
		  freeze= new Image[4];
		  pacsup= new Image[4];
		  pacinv= new Image[4];
		  set();
	  }
	   
	  /*
	   *  0 = Up
	   *  1 = Right
	   *  2 = Down
	   *  3 = Left
	   */
	  public void set() {
		  for (int i = 0 ; i < 4 ; i++) {
			  if (i==2) {
				  blue [i] = new ImageIcon ("res/Ghost/GhostBdown.png").getImage();    red [i] = new ImageIcon ("res/Ghost/GhostRdown.png").getImage();
				  orange [i] = new ImageIcon ("res/Ghost/GhostOdown.png").getImage();  pacpic[i] = new ImageIcon ("res/Player/PacDown.png").getImage();
				  purple [i] = new ImageIcon ("res/Ghost/GhostPdown.png").getImage();  freeze [i] = new ImageIcon("res/Ghost/freezeDown.png").getImage();
				  pacinv[i] = new ImageIcon ("res/Player/invDown.png").getImage();  pacsup[i] = new ImageIcon ("res/Player/superDown.png").getImage();
			  }
			  if (i==1) {
				  blue [i] = new ImageIcon ("res/Ghost/GhostBright.png").getImage();    red [i] = new ImageIcon ("res/Ghost/GhostRright.png").getImage();
				  orange [i] = new ImageIcon ("res/Ghost/GhostOright.png").getImage();  pacpic[i] = new ImageIcon ("res/Player/PacRight.png").getImage();
				  purple [i] = new ImageIcon ("res/Ghost/GhostPright.png").getImage();  freeze [i] = new ImageIcon("res/Ghost/freezeRight.png").getImage();
				  pacinv[i] = new ImageIcon ("res/Player/invRight.png").getImage();  pacsup[i] = new ImageIcon ("res/Player/superRight.png").getImage();
			  }
			  if (i==0) {
				  blue [i] = new ImageIcon ("res/Ghost/GhostBup.png").getImage();    red [i] = new ImageIcon ("res/Ghost/GhostRup.png").getImage();
				  orange [i] = new ImageIcon ("res/Ghost/GhostOup.png").getImage();  pacpic[i] = new ImageIcon ("res/Player/PacUp.png").getImage();
				  purple [i] = new ImageIcon ("res/Ghost/GhostPup.png").getImage();  freeze [i] = new ImageIcon("res/Ghost/freezeUp.png").getImage();
				  pacinv[i] = new ImageIcon ("res/Player/invUp.png").getImage();  pacsup[i] = new ImageIcon ("res/Player/superUp.png").getImage();
			  }
			  if (i==3) {
				  blue [i] = new ImageIcon ("res/Ghost/GhostBleft.png").getImage();    red [i] = new ImageIcon ("res/Ghost/GhostRleft.png").getImage();
				  orange [i] = new ImageIcon ("res/Ghost/GhostOleft.png").getImage();  pacpic[i] = new ImageIcon ("res/Player/PacLef.png").getImage();
				  purple [i] = new ImageIcon ("res/Ghost/GhostPleft.png").getImage();  freeze [i] = new ImageIcon("res/Ghost/freezeLeft.png").getImage();
				  pacinv[i] = new ImageIcon ("res/Player/invLeft.png").getImage();  pacsup[i] = new ImageIcon ("res/Player/superLeft.png").getImage();
			  }	  
		  }
	  }
	  
	  public Image[] getTab (int i) {
		  switch (i) { 
		     case 0 : return blue; 
		     case 1 : return red;	 
		     case 2 : return purple; 
		     case 3 : return orange;
		     case 4 : return pacpic;
		     case 5 : return freeze;
		     case 6 : return pacinv;
		     case 7 : return pacsup;
		  }	  
		  return null ;
	  }

}
