package fr.upec.pacman;

public class Pacman {
    private Game game;
    private GamePanel gamePanel;

    /**
     * CECI EST UNE PREIMPLEMENTATION, A SUIVRE AVEC LE MOUVEMENT
     */
    public void eatPacGum(){
        int trueX = this.getX() / 20;
        int trueY = this.getY() / 20;
        int increment = 0;
        switch (game.getGameMap().getMap().get(trueX).get(trueY)){
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
        game.getGameMap().deletePacGum(trueX, trueY);
        game.setScore(game.getScore() + increment);
        gamePanel.repaint();
    }

    public void eatInvisible(){

    }

    public void eatSuperPower(){

    }

    public void eatMix(){

    }
}
