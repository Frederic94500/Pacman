package fr.upec.pacman;

import java.awt.*;

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
}
