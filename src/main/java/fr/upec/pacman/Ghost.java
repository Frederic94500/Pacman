package fr.upec.pacman;

import java.awt.*;

public class Ghost extends Entity {
    private int counter;
    private boolean turn;

    public Ghost(int x, int y, Image [] pic) {
        super(x, y, 4, 4, Direction.random(), pic);
        this.turn = true;
        this.counter = 0;
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
