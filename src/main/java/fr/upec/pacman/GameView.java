package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GameView extends JComponent {
    public final static int size = 36;
    public final static int WIDTH = 200;
    public final static int HEIGHT = 200;
    private Game game;
    private boolean start; // pour commencer la partie
    private Timer timer; // Ajouter la classe de Action listener
    private Frame frame;
    private boolean eat;
    //Constructeur
    public GameView(Frame f) {
        super();
        setStart(false);
        this.game = new Game(this);
        setOpaque(true);
        setSize(WIDTH, HEIGHT);
        this.timer = new Timer(40, new EnemyAction(game.getGhosts(), this));
        timer.start();
        this.frame = f;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        if (isStart()) {
        if (!game.getPacman().isAlive()) {
            lose(g);
            /*game.restart();*/
        } else {
        	if (game.getPacman().isSuperPow()) {timer.setDelay(80);} else {timer.setDelay(40);}
            if (game.win()) {
                win(g);
                /* game.restart();*/
            } else {
                drawTerrain(g);
                drawEnemy(g);
                drawInterface(g);
                if (eat) { scoreView(g) ;}
            }
        } }  else { startGame(g) ;}
    }

    // Terrain
    private void drawTerrain(Graphics g) {
        g.fill3DRect(0, 0, 600, 600, start);
        g.setColor(Color.GRAY);
        g.fillRect(0, 360, 600, 360);

        int x = 0;
        int y = 0;
        int size = 36;
        // x = width y = height  // size taille du block

        for (Type[] i : game.getMap().getMap()) {
            x = 0;
            for (Type j : i) {
                switch (j) {
                    case W:
                        g.setColor(Color.decode("#2E20BD"));
                        g.fillRect(x, y, size, size);
                        g.setColor(Color.black);
                        g.fillRect(x+3, y+3,  size-6, size-6);
                        break;
                    case C:
                        g.setColor(Color.decode("#EDF033"));
                        g.fillOval(x + 12, y + 12, size - 14 * 2, size - 14 * 2);
                        break;
                    case I:
                        g.setColor(Color.decode("#9f40ff"));
                        g.fillOval(x + 10, y + 10, size - 10 * 2, size - 10 * 2);
                        break;
                    case S:
                        g.setColor(Color.decode("#FFA500"));
                        g.fillOval(x + 10, y + 10, size - 10 * 2, size - 10 * 2);
                        break;
                    case M:
                        g.setColor(Color.decode("#2ed12e"));
                        g.fillOval(x + 10, y + 10, size - 10 * 2, size - 10 * 2);
                        break;
                    case N:
                        g.setColor(Color.black);
                        g.fillRect(x, y, size, size);
                        break;
                    case P:
                        g.setColor(game.getPacman().getColor());
                        g.fillOval(x, y, size, size);
                        g.setColor(Color.black);
                        g.fillOval(x+22, y+3, size+8, size-8);
                        break;
                }
                x += size;
            }
            y += size;
        }
    }

    public void drawInterface(Graphics g) {
        int x = 0;
        for (int i = 0; i < game.getPacman().getLife(); i++) {
            g.setColor(game.getPacman().getColor());
            g.fillOval(x, 360, 36, 36);
            g.setColor(Color.GRAY);
            g.fillOval(x+22, 360+3, 36+8, 36-8);
            x += 36;
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Score: " + game.getScore(), 200, 382);
        if (game.getPacman().isInvisible()) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 17));
            g.drawString("Invisible: " + (10 - (game.getPacman().getInvisibleTimer() / 1000)), 350, 375);
        }
        if (game.getPacman().isSuperPow()) {
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 17));
            g.drawString("Super Power: " + (10 - (game.getPacman().getSuperPowTimer() / 1000)), 350, 390);
        }
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    private void drawEnemy(Graphics g) {
        for (Ghost ghost : game.getGhosts()) {
            g.setColor(ghost.getColor());
            g.fillOval(ghost.getX(), ghost.getY(), size, size);
        }
    }

    public Game getGame() {
        return game;
    }

    private void win(Graphics g) {
        this.timer.stop();
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("YOU WIN !", 200, 200);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Press -SPACE- to restart the game.", 130, 230);
    }

    private void lose(Graphics g) {
        this.timer.stop();
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("YOU LOSE !", 200, 200);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Press -SPACE- to restart the game.", 130, 230);
    }
    
    private void startGame (Graphics g) {
    	g.fillRect(0, 0, 800, 800);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString("Press -SPACE- to start the game !", 90, 200);
        int i = 0 ;
        g.setColor(game.getPacman().getColor());
        g.fillOval(180, 220, size, size);
        g.setColor(Color.black);
        g.fillOval(180+22, 220+3, size+8, size-8);
        for (Ghost ghost : game.getGhosts()) {
            g.setColor(ghost.getColor());
            g.fillOval(230 + i, 220 , size, size);
            i += 46;
        }
       
       
    }
    public void setEat (boolean eat) {this.eat = eat ;}
   
    private void scoreView (Graphics g) {
     	int x = 36*(game.getMap().getPacmanCoords()[1])+ 40 ;int  y =game.getMap().getPacmanCoords()[0]*36 ;
     	g.setColor(Color.YELLOW);
         g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
         g.drawString("+100p", x,y);
     }
    public void setGame(Game game) {this.game =game ;} 
    public Frame getFrame() {return this.frame ;}
    public void startTimer () { this.timer = new Timer(40, new EnemyAction(game.getGhosts(), this));}
}
