package fr.upec.pacman;

import java.awt.*;
import java.util.Random;

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
        this.vx = 1;
        this.vy = 0;
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

    public void randomMove() {
        Random r = new Random();
        this.vx = 0;
        this.vy = 0;
        switch (r.nextInt(4)) { //0 = up, 1 = right, 2 = down, 3 = left
            case 0:
                this.vy = -1;
                break;
            case 1:
                this.vx = 1;
                break;
            case 2:
                this.vy = 1;
                break;
            case 3:
                this.vx = -1;
                break;
        }
    }
}
