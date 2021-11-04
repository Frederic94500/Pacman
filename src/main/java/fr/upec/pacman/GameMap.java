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
                {W, W, W, W, W, W, W, W, W, W, W, W, W, W, W, W},
                {W, C, W, C, C, C, C, C, C, W, C, C, C, C, C, W},
                {W, C, C, C, W, C, W, C, W, W, C, I, C, W, W, W},
                {W, C, C, C, W, C, C, C, C, C, C, W, C, C, C, W},
                {C, C, C, C, C, C, W, C, W, C, C, W, W, C, C, C},
                {W, C, C, W, W, C, C, C, W, C, C, C, C, C, P, W},
                {W, C, C, W, C, C, C, C, C, S, C, W, C, M, C, W},
                {W, C, C, C, C, C, W, C, W, C, C, W, C, C, C, W},
                {W, C, C, C, C, W, C, C, C, C, C, C, C, C, C, W},
                {W, W, W, W, W, W, W, W, W, W, W, W, W, W, W, W}
        };
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

    public void setPacmanCoords(int i, int j) {
        this.map[i][j] = Type.P;
    }

    public void delete(int i, int j) {
        this.map[i][j] = Type.N;
    }
    
}



