package fr.upec.pacman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyAction implements ActionListener {
    private int vxb = 3;
    private int vyb = 3;
    private int vxp = 3;
    private int vyp = 3;
    private int vxo = 3;
    private int vyo = 3;
    private int vxr = 3;
    private int vyr = 3;
    private int cmpb ;
    private int cmpr;
    private int cmpo;
    private int cmpp;
    private ImageSet entity;
    private GameView p;
    private boolean tour = true ; // compteur 
    private boolean tour2 = true ; 
    private boolean tour3 = true ; 
    private boolean tour4 = true ; 

    public EnemyAction(ImageSet entity, GameView p) {
        this.entity = entity;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
    	// rechercher les enemies :
    	   if (!p.getGame().win())  {
        // Blue
  
        if (tour) {
        	if (entity.getBx() <= 36 || entity.getBx() >= 36 * 7) {
                vxb = vxb * -1; // Inverse axe X 
            }
            entity.setBx(entity.getBx() + vxb);
            p.repaint();  
           cmpb++ ;
           if (cmpb == 12) {tour = false ;  cmpb = 0; }
        } else {
            if (entity.getBy() < 36 + 1 | entity.getBy() >= 36 * 7 - 1) {
                // Random direction :
                vyb = vyb * -1;
            }
            entity.setBy(entity.getBy() + vyb);
            p.repaint();   cmpb++;
            if (cmpb == 36) {tour = true ; cmpb = 0;}
        }
	   
        // Red
        if (tour2) {
            if (entity.getRx() <= 36 || entity.getRx() >= 36 * 7) {
                vxr = vxr * -1;
            }

            entity.setRx(entity.getRx() + vxr);
            cmpr++;
            p.repaint();  
            if (cmpr == 24) {tour2 = false ;  cmpr = 0; }
            
        } else {
            if (entity.getRy() < 36 + 1 | entity.getRy() >= 36 * 7 - 1) {
                vyr = vyr * -1;
            }
            entity.setRy(entity.getRy() + vyr);

            cmpr++;          if (cmpr == 24) {tour2 = true ; cmpr = 0;}
            p.repaint();
        }


        //Purple
        if (!tour3) {
            if (entity.getPx() <= 36 || entity.getPx() >= 36 * 7) {
                vxp = vxp * -1;
            }
            entity.setPx(entity.getPx() + vxp);

            cmpp++;
            if (cmpp == 12) {tour3 = true ;  cmpp = 0;}
            p.repaint();
        } else {
            if (entity.getPy() < 36 + 1 | entity.getPy() >= 36 * 7 - 1) {
                vyp = vyp * -1;
            }
            entity.setPy(entity.getPy() + vyp);

            cmpp++;          if (cmpp == 24) {tour3 = false ; cmpp = 0;}
            p.repaint();
        }

        // Orange
        if (!tour4){
            if (entity.getOx() <= 36 || entity.getOx() >= 36 * 7) {
                vxo = vxo * -1;
            }
            entity.setOx(entity.getOx() + vxo);
            cmpo++;
            if (cmpo == 24) {tour4 =true ;  cmpo = 0;}
            p.repaint();
        } else {
           
        	if (entity.getOy() < 36 + 1 | entity.getOy() >= 36 * 7 - 1) {
                vyo = vyo * -1;
            }
            entity.setOy(entity.getOy() + vyo);

            cmpo++;       
            if (cmpo == 36) {tour4 = false ; cmpo = 0;}

            p.repaint();
        }

     
    }}}

