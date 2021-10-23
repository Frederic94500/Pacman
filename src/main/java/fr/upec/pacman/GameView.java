package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GameView extends JComponent {
    public final static int size = 36;
    public final static int WIDTH = 200;
    public final static int HEIGHT = 200;
    private Game game;
    private boolean start; // pour commencer la partie
    private Ghost[] ghosts;
    private Timer timer; // Ajouter la classe de Action listener
    private Frame frame;

    //Constructeur
    public GameView(Frame f) {
        super();
        setStart(false);
        this.game = new Game(this);
        this.ghosts = new Ghost[]{
                new Ghost(size * 2, size * 7, Color.decode("#ea82e5"), 12, 36), //Blue
                new Ghost(size * 7, size * 2, Color.decode("#46bfee"), 24, 24), //Red
                new Ghost(size * 2, size * 2, Color.decode("#db851c"), 12, 24), //Purple
                new Ghost(size * 6, size * 7, Color.decode("#d03e19"), 24, 36)};//Orange
        setOpaque(true);
        setSize(WIDTH, HEIGHT);
        this.timer = new Timer(1, new EnemyAction(ghosts, this));
        timer.start();
        this.frame = f;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);

        if (game.win()) {
            win(g);
            timer = null;
        } else {
            drawTerrain(g);
            drawEnemy(g);
            drawInterface(g);
        }
    }

    // Terrain
    private void drawTerrain(Graphics g) {
        g.fill3DRect(0, 0, 360, 360, start);
        g.setColor(Color.GRAY);
        g.fillRect(0, 360, 360, 360);

        int x = 0;
        int y = 0;
        // x = width y = height  // size taille du block

        for (Type[] i : game.getMap().getMap()) {
            x = 0;
            for (Type j : i) {
                switch (j) {
                    case W:
                        g.setColor(Color.decode("#2E20BD"));
                        g.fillRect(x, y, size, size);
                        break;
                    case C:
                        g.setColor(Color.decode("#EDF033"));
                        g.fillOval(x + 12, y + 12, size - 12 * 2, size - 12 * 2);
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
                        g.setColor(Color.decode("#fdff00"));
                        g.fillOval(x, y, size, size);
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
            g.setColor(Color.YELLOW);
            g.fillOval(x, 360, 36, 36);
            x += 36;
        }
        g.setColor(Color.BLACK);
        g.drawString("Score: " + game.getPacman().getScore(), 200, 382);
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    private void drawEnemy(Graphics g) {
        for (Ghost ghost : ghosts) {
            g.setColor(ghost.getColor());
            g.fillRect(ghost.getX(), ghost.getY(), size, size);
        }
    }

    public Game getGame() {
        return game;
    }

    public Ghost[] getGhosts() {
        return ghosts;
    }

    private void win(Graphics g) {
        this.timer.stop();
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("YOU WIN !", 100, 200);
    }

    private void lose(Graphics g) {
        this.timer.stop();
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.YELLOW);
        g.drawString("YOU LOSE !", 150, 200);
    }
}





