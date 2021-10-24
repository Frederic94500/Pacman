package fr.upec.pacman;

public class GameMap {
    private static final Type W = Type.W; // W = WALL
    private static final Type C = Type.C; // C = CLASSIC
    private static final Type I = Type.I; // I = INVISIBLE
    private static final Type S = Type.S; // S = SUPERPOWER
    private static final Type M = Type.M; // N = NOTHING
    private static final Type P = Type.P; // P = PACMAN
    private int[] pacmanCoords;
    private Type[][] map; // Terrain

    public GameMap() {
        //i = longeur = y | j = largeur = x
        this.map = new Type[][]{
                {W, W, W, W, W, W, W, W, W, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, M, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {C, C, S, C, C, P, C, C, C, C},
                {W, C, C, C, C, C, C, C, I, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, W, W, W, W, W, W, W, W, W}};
    }

    public Type[][] getMap() {
        return map;
    }

    public int[] getPacmanCoords() {
        int x = 0;
        int y = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == P) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        return new int[]{x, y};
    }

    public void setPacmanCoords(int[] tab) {
        this.pacmanCoords = tab;
    }
}



