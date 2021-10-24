package fr.upec.pacman;

import java.awt.*;

public class Pacman extends Entity {
    private float life;
    private int score;
    private boolean alive;

    public Pacman(int x, int y, Color color) {
        super(x, y, color);
        // Le pacman a 3 vie 0 experience. Il se situe au milieu du terrain
        this.life = 3;
        this.score = 0;
        this.alive = true;
    }

    public int getScore() {
        return score;
    }

    public float getLife() {
        return life;
    }

    public void setLife() {
        if (score % 5000 == 0) {
            this.life += 1;
        }
    }

    public boolean loseLife(int bx, int by, int rx, int ry, int px, int py, int ox, int oy, int pacy, int pacx, Game game) {
        if ((pacx == px && pacy == py) || (pacx == rx && pacy == ry) || (pacx == bx && pacy == by) || (pacx == ox && pacy == oy)) {
            life = life - 1;
            game.getMap().setPacmanCoords(new int[]{8, 8});
            for (Ghost g : game.getGhosts()) {
                g.setX(72);
                g.setY(72);
            }

            if (life <= 0) {
                setAlive(false);
            }
            return true;
        }
        return false;
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
}
