package fr.upec.pacman;

import java.awt.*;

public class Pacman extends Entity {
    private float life;
    private int score;
    private boolean alive = true;
    private int pacGum;

    public Pacman(int x, int y, Color color) {
        super(x, y, color);
        // Le pacman a 3 vie 0 experience. Il se situe au milieu du terrain
        this.life = 3;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public float getLife() {
        return life;
    }

    public void setLife(int life) {
        if (score % 5000 == 0) {
            this.life += 1;
        }
    }

    public void loseLife(int[] ghostCoords, int[] pacmanCoords) {
        if (ghostCoords[0] / 36 == pacmanCoords[0] && ghostCoords[1] / 36 == pacmanCoords[1]) {
            life--;
        }

        if (life <= 0) {
            this.alive = false;
        }
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void eatInvisible() {

    }

    public void eatSuperPow() {

    }

    public void eatMix() {

    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void incrementPacGum() {
        pacGum++;
    }

    public int getPacGum() {
        return pacGum;
    }
}
