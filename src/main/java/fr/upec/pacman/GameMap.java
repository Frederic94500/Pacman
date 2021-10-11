package fr.upec.pacman;

public class GameMap {
    private static final Type W = Type.W; // W = WALL
    private static final Type C = Type.C; // C = CLASSIC
    private static final Type I = Type.I; // I = INVISIBLE
    private static final Type S = Type.S; // S = SUPERPOWER
    private static final Type M = Type.M; // M = MIX
    private static final Type N = Type.N; // N = NOTHING
    private static final Type P = Type.P; // P = PACMAN
    private static final Type GR = Type.GR; // G = GHOSTRed
    private static final Type GB = Type.GB; // G = GHOSTBlue
    private static final Type GO = Type.GO; // G = GHOSTOrange
    private static final Type GP = Type.GP; // G = GHOSTPurple

    private Type[][] map; // Terrain
    
    public GameMap() {
        //i = hauteur = y | j = largeur = x
        this.map = new Type[][]{
            {W, W, W, W, W, W, W, W, W, W},
            {W, GR, C, C, C, C, C, C, GO, W},
            {W, C, C, C, C, C, C, M, C, W},
            {W, C, C, C, C, C, C, C, C, W},
            {C, C, S, C, C, P, C, C, C, C},
            {W, C, C, C, C, C, C, C, I, W},
            {W, C, C, C, C, C, C, C, C, W},
            {W, C, C, C, C, C, C, C, C, W},
            {W, GP, C, C, C, C, C, C, GB, W},
            {W, W, W, W, W, W, W, W, W, W}};
    }
    
    public Type[][] getMap() {
        return this.map;
    }
    
    public void setMap(Type[][] map) {
         this.map = map;
    }

    public void changeType(int x, int y, Type type){
        this.map[x][y] = type;
    }

    public void deleteType(int x, int y){
        this.map[x][y] = N;
    }
}
