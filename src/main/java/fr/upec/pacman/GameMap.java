package fr.upec.pacman;

public class GameMap {
    private static final Type W = Type.W; // W = WALL
    private static final Type C = Type.C; // C = CLASSIC
    private static final Type I = Type.I; // I = INVISIBLE
    private static final Type S = Type.S; // S = SUPERPOWER
    private static final Type M = Type.M; // N = NOTHING
    private static final Type P = Type.P; // P = PACMAN
    private static final Type Gr = Type.Gr; // G = GHOSTRed
    private static final Type Gb = Type.Gb; // G = GHOSTBlue
    private static final Type Go = Type.Go; // G = GHOSTOrange
    private static final Type Gp = Type.Gp; // G = GHOSTPurple

    private Type[][] map; // Terrain
    
    public GameMap() {
        //i = longeur = y | j = largeur = x
        this.map = new Type[][]{
            {W, W, W, W, W, W, W, W, W, W},
            {W, Gr, C, C, C, C, C, C, Go, W},
            {W, C, C, C, C, C, C, M, C, W},
            {W, C, C, C, C, C, C, C, C, W},
            {C, C, S, C, C, P, C, C, C, C},
            {W, C, C, C, C, C, C, C, I, W},
            {W, C, C, C, C, C, C, C, C, W},
            {W, C, C, C, C, C, C, C, C, W},
            {W, Gp, C, C, C, C, C, C, Gb, W},
            {W, W, W, W, W, W, W, W, W, W}};
    }
    
    
    public Type[][] getMap() {
        return map;
    }
    
    public void setMap(Type[][] tab) {
         map = tab;
    }
}
