package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GameView extends JComponent{
    private GameMap game;
	public final static int WIDTH = 200;
	public final static int HEIGHT = 200;
    private boolean start ; // pour commencer la partie 
    
    private JLabel blue ;
    

    //Constructeur 
    public GameView() {
    	super();
    	setStart(false) ;
        game = new GameMap ( ) ;
    	setOpaque(true);
		setSize(WIDTH, HEIGHT);
		addKeyListener (new Pacmove ()) ;
		
    }

    
    
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
        g.setColor(Color.black);
    	Drawtable (g) ;
   
        }
    

    // Terrain
    private void  Drawtable (Graphics g ) {
    	
    	int x = 0; int y = 0; int size = 36;
          // x = width y = height  // size taille du block 
     
          for (int i = 0 ; i < game.getMap().length ; i++) {
              x = 0;
              for (int j = 0 ; j < game.getMap()[i].length ; j++) {
              
              	switch (game.getMap()[i][j]){
                      case W:
                          g.setColor(Color.BLACK);
                          g.fillRect(x, y, size, size);  // Yo Fred jte conseille d'utiliser des cercles pour les pacgommes :p
                          break;
                      case C:
                          g.setColor(Color.decode("#2020d4"));
                          g.fillRect(x+7, y+7, size-7*2, size-7*2);
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
                        //  g.setColor(Color.WHITE);
                       //   g.fillRect(x, y, size, size);
                      case G:
                          //g.setColor(Color.WHITE);
                        //  g.fillRect(x, y, size, size);
                  }
                  x += size;
              }
              y += size;
          } 
    	
    }
    
    



	public boolean isStart() {
		return start;
	}



	public void setStart(boolean start) {
		this.start = start;
	}
}
