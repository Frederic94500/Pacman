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
        if (!game.getPacman().isAlive()) {
            lose(g);
            /*game.restart();*/
        } else {
            if (game.win()) {
                win(g);
                /* game.restart();*/
            } else {
                drawTerrain(g);
                drawEnemy(g);
                drawInterface(g);
            }
        }
    }

    // Terrain
    private void drawTerrain(Graphics g) {
        g.fill3DRect(0, 0, 360, 360, start);
        g.setColor(Color.GRAY);
        g.fillRect(0, 360, 360, 360);

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
                        g.setColor(game.getPacman().getColor());
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
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Score: " + game.getPacman().getScore(), 200, 382);
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
            g.fillRect(ghost.getX(), ghost.getY(), size, size);
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
        g.drawString("YOU WIN !", 100, 200);
    }

    private void lose(Graphics g) {
        this.timer.stop();
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("YOU LOSE !", 100, 200);
    }
}
