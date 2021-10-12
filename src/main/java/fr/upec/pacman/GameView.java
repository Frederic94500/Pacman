package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GameView extends JComponent {
    private Game game;
	public final static int WIDTH = 200;
	public final static int HEIGHT = 200;
    private boolean start ; // pour commencer la partie
    private ImageSet entity ; //A enlever (image interdite)

    //Constructeur 
    public GameView(Game game) {
    	super();
    	setStart(false);
        this.game = game;
        this.entity = new ImageSet(); // on charge les images (va être supprimé)
        setOpaque(true);
		setSize(WIDTH, HEIGHT);
		addKeyListener(game.getMove());
    }

    @Override
    public void paint(Graphics g) {
    	super.paint(g);
        g.setColor(Color.black);
    	drawTerrain(g) ;
        drawInterface(g);
    }

    // Terrain
    private void drawTerrain(Graphics g) {
    	g.fill3DRect(0, 0, 360, 360, start);   
    	g.setColor(Color.GRAY);
    	g.fillRect(0, 360, 360, 360);   
    		  	
    	int x = 0; int y = 0; int size = 36;
          // x = width y = height  // size taille du block 

        for (Type[] i: game.getMap().getMap()) {
            x = 0;
            for (Type j: i) {
                switch (j){
                    case W:
                        g.setColor(Color.decode("#2E20BD"));
                        g.fillRect(x, y, size, size);
                        break;
                    case C:
                        g.setColor(Color.decode("#ffffa6"));
                        g.fillOval(x+12, y+12, size-12*2,size-12*2);
                        break;
                    case I:
                        g.setColor(Color.decode("#9f40ff"));
                        g.fillOval(x+10, y+10, size-10*2,size-10*2);
                        break;
                    case S:
                        g.setColor(Color.decode("#FFA500"));
                        g.fillOval(x+10, y+10, size-10*2,size-10*2);
                        break;
                    case M:
                        g.setColor(Color.decode("#2ed12e"));
                        g.fillOval(x+10, y+10, size-10*2,size-10*2);
                        break;
                    case N:
                        g.setColor(Color.GRAY);
                        g.fillRect(x, y, size, size);
                    case P:
                        g.setColor(game.getPacman().getColor());
                        g.fillOval(x, y, 36, 36);
                        break;
                    case GB:
                        g.setColor(Color.decode("#ea82e5"));
                        g.fillRect(x, y, 36, 36);
                        break;
                    case GR:
                        g.setColor(Color.decode("#46bfee"));
                        g.fillRect(x, y, 36, 36);
                        break;
                    case GO:
                        g.setColor(Color.decode("#d03e19"));
                        g.fillRect(x, y, 36, 36);
                        break;
                    case GP:
                        g.setColor(Color.decode("#db851c"));
                        g.fillRect(x, y, 36, 36);
                        break;
                }
                x += size;
            }
            y += size;
        }
    }

    public void drawInterface(Graphics g){
        int x = 0;
        for (int i = 0; i < game.getPacman().getLife(); i++) {
            g.setColor(Color.YELLOW);
            g.fillOval(x, 360, 36, 36);
            x += 36;
        }
        g.setColor(Color.BLACK);
        g.drawString("Score: " + game.getPacman().getScore(), 0, 410);
    }

    /**
     * @deprecated Va être supprimé
     */
    /*private void image(Graphics g) {
    	// 3 Points de vie 
    	int x_add = 0  ;
    	int y_add = 360 ;
    	
    	entity.setHx(x_add); 
    	entity.setHy(y_add);
    	
        for (int i = 0; i < game.getPacman().getLife(); i++) {
            g.drawImage(entity.getHeart(), entity.getHx(), entity.getHy(), null);
            x_add += 36;
            entity.setHx(x_add);
        }
    }*/

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}
}
