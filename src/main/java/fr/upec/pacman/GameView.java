package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GameView extends JComponent {
    public  final static int size = 36;
    public  Image heart = new ImageIcon ("res/Game/Heart.png").getImage();
    public  Image win = new ImageIcon ("res/Game/win.png").getImage();
    public  Image lose= new ImageIcon ("res/Game/lose.png").getImage();
    public  Image play = new ImageIcon ("res/Game/start.png").getImage();
    private final int footerX;
    private final int footerY;
    private boolean start; // pour commencer la partie
    private boolean eat;
    private Game game;
    private Timer timerGhost; // Ajouter la classe de Action listener
    private Timer timerPacman;
    private Frame frame;
    private int scoreGet;

    //Constructeur
    public GameView(Frame f, Game game) {
        super();
        setStart(false);
        setOpaque(true);
        this.timerGhost = new Timer(40, new EnemyAction(game.getGhosts(), game, this));
        this.timerPacman = new Timer(40, new PacAction(game, this, game.getPacman()));
        this.frame = f;
        this.game = game;
        this.footerX = game.getMap().getMap()[0].length * size;
        this.footerY = game.getMap().getMap().length * size;
        this.scoreGet = 0;
    }

    public void setScoreGet(int scoreGet) {
        this.scoreGet = scoreGet;
    }

    public Frame getFrame() {
        return frame;
    }

    public Timer getTimerGhost() {
        return timerGhost;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        if (isStart()) {
            timerGhost.start();
            timerPacman.start();
            if (!game.getPacman().isAlive()) {
                loseScreen(g);
            } else {
                if (game.win()) {
                    winScreen(g);
                } else {
                    drawTerrain(g);
                    drawPacman(g);
                    drawEnemy(g);
                    drawFooter(g);
                    if (eat) {
                        scoreBubble(g);
                    }
                }
            }
        } else {
            startScreen(g);
        }
    }

    // Terrain
    private void drawTerrain(Graphics g) {
        g.fill3DRect(0, 0, game.getMap().getMap()[0].length * size, game.getMap().getMap().length * size, start);

        int x = 0;
        int y = 0;
        // x = width y = height  // size taille du bloc

        for (Type[] i : game.getMap().getMap()) {
            x = 0;
            for (Type j : i) {
                switch (j) {
                    case W:
                        g.setColor(Color.decode("#2E20BD"));
                        g.fillRect(x, y, size, size);
                        g.setColor(Color.black);
                        g.fillRect(x + 3, y + 3, size - 6, size - 6);
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
                }
                x += size;
            }
            y += size;
        }
    }

    private void drawFooter(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, footerY, 610, 370);
        for (int i = 0; i < game.getPacman().getLife(); i++) {
        	g.drawImage(heart,i * 32,footerY, this);
        }
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + game.getScore(), footerX / 3, footerY + 22);
        if (game.getPacman().isInvisible()) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 17));
            g.drawString("Invisible: " + (10 - (game.getPacman().getInvisibleTimer() / 1000)), (footerX / 3) * 2, footerY + 15);
        }
        if (game.getPacman().isSuperPow()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.PLAIN, 17));
            g.drawString("Super Power: " + (10 - (game.getPacman().getSuperPowTimer() / 1000)), (footerX / 3) * 2, footerY + 30);
        }
    }

    private void drawPacman(Graphics g) {
    	g.drawImage(game.getPacman().getMypic(),game.getPacman().getX(), game.getPacman().getY(),this);
    }

    private void drawEnemy(Graphics g) {
        for (Ghost ghost : game.getGhosts()) {
            g.drawImage(ghost.getMypic(),ghost.getX(), ghost.getY(), this );
        }
    }

    private void scoreBubble(Graphics g) {
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("+" + scoreGet, (game.getPacman().getX() * size) + 40, game.getPacman().getY() * size); //bugge
    }

    private void startScreen(Graphics g) {
    	g.drawImage(play, 0, 0, this);
    }

    private void winScreen(Graphics g) {
        this.timerGhost.stop();
        this.timerPacman.stop();
        g.drawImage(win, 0, 0, this);
    }

    private void loseScreen(Graphics g) {
        this.timerGhost.stop();
        this.timerPacman.stop();
        g.drawImage(lose, 0, 0, this);
    }
}
