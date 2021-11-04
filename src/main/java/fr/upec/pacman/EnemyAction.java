package fr.upec.pacman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class EnemyAction implements ActionListener {
    private Ghost[] ghosts;
    private GameView p;

    public EnemyAction(Ghost[] ghosts, GameView p) {
        this.ghosts = ghosts;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ghost g : ghosts) {
            if (g.isTurn()) {
                // Axe des X
                wall(g, false);
          
            } else {
                // Axe des y
                wall(g, true);
            }
            p.repaint();
            checkLife(); // Verifie si ca touche
        }
    }

    private void checkLife() {
        if (p.getGame().checkLife()) {
            try {
                for (Ghost g : ghosts) {
                    g.setCounter(0);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
            }
        }
    }

    //Choix de la trajectoire des fantomes dynamique :
    private void wall(Ghost g, boolean choice) {
        int x = g.getX();int y = g.getY();
        int calibrageY= 0; int calibrageX =0;int r = (int) (Math.random()*2);
        
        if (choice ) {
        	
        	    if (g.getDy()> 0 ){ if (y/36 > 0) calibrageY = 36; calibrageX = 0;} 
        	    else {if (y/36 > 0) calibrageY =-36 ; calibrageX = 0 ;}
        } else { 
        	    if (g.getDx()> 0){ if (x/36 > 0) calibrageX = 36; calibrageY = 0;} 
        	    else {if (x/36 > 0) calibrageX =-36 ;calibrageY = 0 ;} 
        }
        
        if (g.getX()== 0  || g.getX()== 15*36) {g.setDx(g.getDx()*-1) ; g.setCounter(0);}
       
       
       switch (p.getGame().getMap().getMap()[(y+calibrageY)/36 ][(x+calibrageX)/36 ]) {
          case W :
        	 if (choice) {      
        	     if (r == 0) { g.setDy(g.getDy() * -1) ; g.setCounter(r*9);}
        	          else {if (g.getX( ) % 36 == 0& g.getY( ) % 36 == 0)  g.setTurn(true); g.setCounter(r*9);} 
        	 } 
        	 else { 
          		 if (r == 0) { g.setDx(g.getDx() * -1) ; g.setCounter(r*9);} 
          		     else {if (g.getX() % 36 == 0& g.getY() % 36 == 0) g.setTurn(false); g.setCounter(r*9);}
            	 }  
             break; 	
        
          default  : 
        	  if (choice) {
                 g.setY(g.getY() + g.getDy());
                 g.incrementCounter();
                 if (g.getCounter() == 27 & g.getY( ) % 36 == 0 ) {
                     g.setTurn(true);
                     g.setCounter(0);     
                 }
       	      } else {     
       		     g.setX(g.getX() + g.getDx());
                 g.incrementCounter();
                 if (g.getCounter() == 18+ r*9 & g.getX( ) % 36 == 0 ) {
            	     g.setTurn(false);
                     g.setCounter(0);
                 }
              }
             break; 
        }
    }
    
    
}




