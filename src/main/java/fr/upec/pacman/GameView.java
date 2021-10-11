package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GameView extends JComponent{
    private GameMap game;
	public final static int WIDTH = 200;
	public final static int HEIGHT = 200;
    private boolean start ; // pour commencer la partie 
    private ImageSet entity ;
    private Pacman player ;

    
    
    //Constructeur 
    public GameView() {
    	super();
    	setStart(false) ;
    	player = new Pacman () ;
        game = new GameMap ( ) ;  // on charge le terrain 
        entity= new ImageSet () ; // on charge les images
        setOpaque(true);
		setSize(WIDTH, HEIGHT);
		addKeyListener (new Pacmove ()) ;
		
    }

    
    
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
        g.setColor(Color.black);
    	Drawtable (g) ;
    	Image (g);
        }
    

    // Terrain
    private void  Drawtable (Graphics g ) {
    	g.fill3DRect(0, 0, 360, 360, start);   
    	g.setColor(Color.GRAY);
    	g.fillRect(0, 360, 360, 360);   
    		  	
    	int x = 0; int y = 0; int size = 36;
          // x = width y = height  // size taille du block 
     
          for (int i = 0 ; i < game.getMap().length ; i++) {
              x = 0;
              for (int j = 0 ; j < game.getMap()[i].length ; j++) {
              
              	switch (game.getMap()[i][j]){
                      case W:
                          g.setColor(Color.decode("#2E20BD"));
                          g.fillRect(x, y, size, size);  // Yo Fred jte conseille d'utiliser des cercles pour les pacgommes :p
                          break;
                      case C:
                          g.setColor(Color.decode("#EDF033"));                  
                          g.fillOval(x+7, y+7, size-7*3,size-7*3);
                          break;
                      case I:
                          g.setColor(Color.decode("#9f40ff"));
                          g.fillRect(x+4, y+4, size-4*2, size-4*2);
                          break;
                      case S:
                          g.setColor(Color.decode("#FFA500"));
                          g.fillRect(x+4, y+4, size-4*2, size-4*2);
                          break;
                      case M:
                          g.setColor(Color.decode("#2ed12e"));
                          g.fillRect(x+4, y+4, size-4*2, size-4*2);
                          break;
                      case N:
                          g.setColor(Color.WHITE);
                          g.fillRect(x, y, size, size);
                      case P:
                          g.drawImage(entity.getPacman(), x, y, null) ;
                          break;
                      case Gb:
                    	   g.drawImage(entity.getGhostBlue(), x, y, null) ;
                    	   break;
                      case Gr:
                   	   g.drawImage(entity.getGhostRed(), x, y, null) ;
                     	 break;
                      case Go:
                   	   g.drawImage(entity.getGhostOrange(), x, y, null) ;
                   	    break;
                      case Gp:
                      	   g.drawImage(entity.getGhostPurple(), x, y, null) ;
                      	    break;
                   	   
                  }
                  x += size;
              }
              y += size;
          } 
          
    }
    
    

    private void Image (Graphics g) {
    	// 3 Points de vie 
    	int x_add = 0  ;
    	int y_add = 360 ;
    	
    	entity.setHx(x_add); 
    	entity.setHy(y_add);
    	
        for (int i = 0 ; i < player.getVie() ; i++) {
        	
    	g.drawImage(entity.getHeart(), entity.getHx(), entity.getHy(), null);
    	x_add += 36  ;
    	entity.setHx(x_add); 
        }
    	
    }


	public boolean isStart() {
		return start;
	}



	public void setStart(boolean start) {
		this.start = start;
	}
}
