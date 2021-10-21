package fr.upec.pacman;

import java.awt.*;

public class Ghost extends Entity {
    private Color color;
    private int vx;
    private int vy;
    private int cmp; //cmp? qu'est-ce que c'est? Compagnie du chemin de fer Métropolitain de Paris?
    private boolean tour;

    public Ghost(int x, int y, Color color) {
        super(x, y);
        this.color = color;
        this.tour = true;
        this.vx = 3;
        this.vy = 3;
        this.cmp = 0;
    }

    public Color getColor() {
        return color;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getCmp() {
        return cmp;
    }

    public void setCmp(int cmp) {
        this.cmp = cmp;
    }

    public boolean isTour() {
        return tour;
    }

    public void setTour(boolean tour) {
        this.tour = tour;
    }

    public void incrementCmp() {
        this.cmp++;
    }
}
