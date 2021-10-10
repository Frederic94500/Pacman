package fr.upec.pacman;

public class Pacman {
    private Game game;
    private int lives;

    public Pacman(Game game) {
        this.game = game;
        this.lives = 3;
    }

    /**
     * CECI EST UNE PREIMPLEMENTATION, A SUIVRE AVEC LE MOUVEMENT
     */
    public void eatPacGum(){
        int mapX = this.getX() / 20;
        int mapY = this.getY() / 20;
        int increment = 0;
        switch (game.getGameMap().getTypeInMap(mapX, mapY)){
            case W:
                /*Code qui bloque pacman*/
            case C:
                /*Code qui fait manger le pacgum, incrémente le score et redessine le terrain*/
                increment = 100;
            case I:
                /*Code qui rend pacman invisible et redessine le terrain*/
                increment = 300;
            case S:
                /*Code qui rend pacman puissant et redessine le terrain*/
                increment = 500;
            case M:
                /*Code qui mélange la map*/
                increment = 1000;
            case N:
                /*Code qui ignore*/
        }
        game.getGameMap().deletePacGum(mapX, mapY);
        game.setScore(game.getScore() + increment);
        game.getGamePanel().repaint();
    }

    public void eatInvisible(){

    }

    public void eatSuperPower(){

    }

    public void eatMix(){

    }

    public  void gainLife(){
        if(game.getScore() % 5000)
    }

    public void loseLife(){
        lives--;
    }
}
