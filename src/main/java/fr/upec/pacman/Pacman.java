package fr.upec.pacman;

public class Pacman /*extends Entity*/ {
    private float life;
    private int score;
    private boolean alive = true;
    private int pacgum;
    /*private int x;
    private int y;*/

    public Pacman(/*int x, int y*/) {
        //super(x, y);
        // Le pacman a 3 vie 0 experience. Il se situe au milieu du terrain
        this.life = 3;
        this.score = 0;
        /*this.x = 100;
        this.y = 50;*/
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

    /*public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getCoords() {
        return new int[]{x, y};
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }*/

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

    public void incrementPacgum() {
        pacgum++;
    }

    public int getPacgum() {
        return pacgum;
    }
}
