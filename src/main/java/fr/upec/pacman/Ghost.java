package fr.upec.pacman;

import java.awt.*;
import java.util.Random;

public class Ghost extends Entity {
    private int counter; //cmp? qu'est-ce que c'est? Compagnie du chemin de fer Métropolitain de Paris?
    private boolean turn;

    public Ghost(int x, int y, Color color) {
        super(x, y, color);
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

    //Voir branche AlternativeWall
    public void randomMove() {
        Random r = new Random();
        super.setDx(0);
        super.setDy(0);
        switch (r.nextInt(4)) { //0 = up, 1 = right, 2 = down, 3 = left
            case 0:
                super.setDy(-4);
                break;
            case 1:
                super.setDx(4);
                break;
            case 2:
                super.setDy(4);
                break;
            case 3:
                super.setDx(-4);
                break;
        }
    }
}
