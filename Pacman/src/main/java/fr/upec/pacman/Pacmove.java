package fr.upec.pacman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pacmove implements KeyListener  {
	
	private GameView p ;
	
	
	public Pacmove (GameView p) {
		this.p = p ;
	}
	
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
	try {	
		
		Pacman player = p.getGame().getPacman();
		Thread.sleep(100) ;
		Type [] [] map = p.getGame().getMap().getMap();

		int k = e.getKeyCode() ;    
		  
		if(k  == KeyEvent.VK_LEFT) {
			Thread.sleep(300) ;
		        	for (int i = 0 ; i < map.length ; i++) {
		        		
		    			for(int j = 0 ; j < map[i].length ; j++) {
		    			// On cherche la place du pacman.
		    			    if (map [i][j] == Type.P ) { 
		    				
		    			    	if(j !=0) {
		    				    if (map [i][j-1] != Type.W   ) {
		    				    	if(map [i][j-1] == Type.C) {player.setScore(player.getScore()+10) ;  }
		    				    	map [i][j] = Type.N ; 
		    			    	    map [i][j-1] = Type.P ;
		    			    	    p.repaint();break;    
		    				    }
		    			     	
		    				    player.setX(player.getX() - 36) ; 
		    				}else { 	
	    			     		map [i][j] = Type.N ; 
    			    	        map [i][map[i].length  - 1] = Type.P ;
    			    	        if(map [i][0] == Type.C) {player.setScore(player.getScore()+10) ;  }
    			    	        player.setX(36*9) ; 
    			    	        
    			    	        
    			    	        }
		    				} 
		    		}}}
		        	
		        
	        	// Right  
		if(k  == KeyEvent.VK_RIGHT) {
			Thread.sleep(300) ;
			for (int i = 0 ; i < map.length ; i++) {
    			for(int j = 0 ; j < map[i].length ; j++) { 
    				if (map[i][j] == Type.P) {
    					
    					if (j != map[i].length -1) {
    						if (map[i][j+1] != Type.W) {
    						if(map [i][j+1] == Type.C) {player.setScore(player.getScore()+10) ;  }
    				    	map [i][j] = Type.N ; 
    			    	    map [i][j+1] = Type.P ;
    			    	    player.setY(player.getX()+36) ; 
    			    	    j = 100; i = 100 ; // stop boucle 
    					  }
    				    }else {
    				    if(map [i][0] == Type.C) {player.setScore(player.getScore()+10) ;  }
				    	map [i][j] = Type.N ; 
			    	    map [i][0] = Type.P ;
			    	    player.setY(0) ; 
			    	    j = 100; i = 100 ;}
    					
    				}
    				
    			}
    			

}
			
			
		}
							
			    // Up
		
			if (k == KeyEvent.VK_DOWN) {
				Thread.sleep(300) ;
for (int i = 0 ; i < map.length ; i++) {
		    			for(int j = 0 ; j < map[i].length ; j++) { 
		    				if (map[i][j] == Type.P) {
		    					if (map[i+1][j] != Type.W) {
		    						if(map [i+1][j] == Type.C) {player.setScore(player.getScore()+10) ;  }
		    				    	map [i][j] = Type.N ; 
		    			    	    map [i+1][j] = Type.P ;
		    			    	    player.setY(player.getY()-36) ; 
		    			    	    j = 100; i = 100 ; // stop boucle 
		    					}
		    					
		    					
		    					
		    				}
		    				
		    			}
		    			

}
					
				}
				// Down 
				if(k == KeyEvent.VK_UP) {
					Thread.sleep(300) ;
					
					for (int i = 0 ; i < map.length ; i++) {
	    			for(int j = 0 ; j < map[i].length ; j++) { 
	    				if (map[i][j] == Type.P) {
	    					if (i != 0) {
	    					if (map[i-1][j] != Type.W) {
	    						if(map [i-1][j] == Type.C) {player.setScore(player.getScore()+10) ;  }
	    				    	map [i][j] = Type.N ; 
	    			    	    map [i-1][j] = Type.P ;
	    			    	    player.setY(player.getY()+36) ; 
	    					} }
	    					
	    					
	    					
	    				}
	    				
	    			}
	    			

}}
				Thread.sleep(300) ;
				p.repaint();} catch (Exception em) {}
	
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
