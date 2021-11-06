package fr.upec.pacman;

import java.awt.*;
import java.util.Random;

public class Ghost extends Entity {
    private int dx;
    private int dy;
    private int counter;
    private boolean turn;

    public Ghost(int x, int y, Color color) {
        super(x, y, color);
        this.turn = true;
        this.dx = 4;
        this.dy = 4;
        this.counter = 0;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void incrementCounter() {
        this.counter++;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    //Voir branche AlternativeWall
    public void randomMove() {
        Random r = new Random();
        this.dx = 0;
        this.dy = 0;
        switch (r.nextInt(4)) { //0 = up, 1 = right, 2 = down, 3 = left
            case 0:
                this.dy = -4;
                break;
            case 1:
                this.dx = 4;
                break;
            case 2:
                this.dy = 4;
                break;
            case 3:
                this.dx = -4;
                break;
        }
    }
}
