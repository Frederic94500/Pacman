package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GameView extends JComponent {
    public final static int size = 36;
    public final static int WIDTH = 200;
    public final static int HEIGHT = 200;
    private Game game;
    private boolean start; // pour commencer la partie
    //private ImageSet entity; //A enlever (image interdite)
    private Ghost[] ghosts;
    private Timer timer; // Ajouter la classe de Action listener
    private Frame frame;

    //Constructeur
    public GameView(Frame f) {
        super();
        setStart(false);
        this.game = new Game(this);
        //this.entity = new ImageSet(); // on charge les images (va être supprimé)
        this.ghosts = new Ghost[]{
                new Ghost(size * 2, size * 7, Color.decode("#ea82e5")), //Blue
                new Ghost(size * 7, size * 2, Color.decode("#46bfee")), //Red
                new Ghost(size * 2, size * 2, Color.decode("#db851c")), //Purple
                new Ghost(size * 6, size * 7, Color.decode("#d03e19"))};//Orange
        setOpaque(true);
        setSize(WIDTH, HEIGHT);
        //setEntity();
        this.timer = new Timer(40, new EnemyAction(ghosts, this));
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
            //image(g);
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
                        g.fillRect(x, y, size, size);  // Yo Fred jte conseille d'utiliser des cercles pour les pacgommes :p
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

    /*/**
     * @param
     * @deprecated Va être supprimé

    private void image(Graphics g) {
        // 3 Points de vie
        int x_add = 0;
        int y_add = 360;

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

    private void drawEnemy(Graphics g) {
        for (Ghost ghost : ghosts) {
            g.setColor(ghost.getColor());
            g.fillRect(ghost.getX(), ghost.getY(), size, size);
        }

        /*g.drawImage(entity.getGhostBlue(), entity.getBx(), entity.getBy(), null);
        g.drawImage(entity.getGhostPurple(), entity.getPx(), entity.getPy(), null);
        g.drawImage(entity.getGhostOrange(), entity.getOx(), entity.getOy(), null);
        g.drawImage(entity.getGhostRed(), entity.getRx(), entity.getRy(), null);*/
    }

    public Game getGame() {
        return game;
    }

    /*public void setEntity() {

        entity.setBx(36 * 2);
        entity.setBy(36 * 7);

        entity.setRx(36 * 7);
        entity.setRy(36 * 2);

        entity.setPx(36 * 2);
        entity.setPy(36 * 2);

        entity.setOx(36 * 6);
        entity.setOy(36 * 7);
    }

    public ImageSet getEntity() {
        return entity;
    }*/

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





