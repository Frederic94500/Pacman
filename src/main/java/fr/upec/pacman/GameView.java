package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GameView extends JComponent {
    public final static int WIDTH = 200;
    public final static int HEIGHT = 200;
    private Game game;
    private boolean start; // pour commencer la partie
    private ImageSet entity; //A enlever (image interdite)
    private Timer timer; // Ajouter la classe de Action listener

    //Constructeur 
    public GameView() {
        super();
        setStart(false);
        this.game = new Game();
        this.entity = new ImageSet(); // on charge les images (va être supprimé)
        setOpaque(true);
        setSize(WIDTH, HEIGHT);
        setEntity() ;
        this.timer = new Timer(1000, new EnemyAction(entity, this));
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);

        image(g);
        drawtable(g);
        drawEnemy(g);
    }

    // Terrain
    private void drawtable(Graphics g) {
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
                        g.drawImage(entity.getPacman(), x, y, null);
                        break;
                    case Gb:
                        g.drawImage(entity.getGhostBlue(), x, y, null);
                        break;
                    case Gr:
                        g.drawImage(entity.getGhostRed(), x, y, null);
                        break;
                    case Go:
                        g.drawImage(entity.getGhostOrange(), x, y, null);
                        break;
                    case Gp:
                        g.drawImage(entity.getGhostPurple(), x, y, null);
                        break;
                }
                x += size;
            }
            y += size;
        }
    }

    /**
     * @param g
     * @deprecated Va être supprimé
     */
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
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }


    private void drawEnemy(Graphics g) {
        g.drawImage(entity.getGhostBlue(), entity.getBx(), entity.getBy(), null);
        g.drawImage(entity.getGhostPurple(), entity.getPx(), entity.getPy(), null);
        g.drawImage(entity.getGhostOrange(), entity.getOx(), entity.getOy(), null);
        g.drawImage(entity.getGhostRed(), entity.getRx(), entity.getRy(), null);
    }

    public Game getGame() {
        return game;
    }
    
    public void setEntity() { 

    	entity.setBx(36 * 2);
        entity.setBy(36 * 3);

        entity.setRx(72);
        entity.setRy(36 * 7);

        entity.setPx(36 * 7);
        entity.setPy(36 * 2);

        entity.setOx(36 * 7);
        entity.setOy(36 * 7);}
}




