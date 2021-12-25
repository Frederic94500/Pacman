package fr.upec.pacman;

public class GameMap {
    private static final Type W = Type.W; // W = WALL
    private static final Type C = Type.C; // C = CLASSIC
    private static final Type I = Type.I; // I = INVISIBLE
    private static final Type S = Type.S; // S = SUPERPOWER
    private static final Type M = Type.M; // M = MIX
    private static final Type N = Type.N; // N = NOTHING
    private Type[][] map;
    private boolean blockingWall;

    public GameMap() {
        //i = longeur = y | j = largeur = x
        this.map = new Type[][]{
                {W, W, W, W, W, W, W, W, W, W, W, W, W, W, W, W, W},
                {W, M, C, C, N, C, C, C, I, C, C, C, N, C, C, I, W},
                {W, C, W, C, W, C, W, W, W, W, W, C, W, C, W, C, W},
                {W, C, C, C, C, C, C, C, C, C, C, C, C, C, C, C, W},
                {W, W, W, C, W, C, W, W, W, W, W, C, W, C, W, W, W},
                {N, N, W, C, W, C, C, C, C, C, C, C, W, C, W, N, N},
                {W, W, W, N, W, C, W, C, W, C, W, C, W, N, W, W, W},
                {N, N, N, N, W, C, C, M, S, M, C, C, W, N, N, N, N},
                {W, W, W, N, W, C, W, C, W, C, W, C, W, N, W, W, W},
                {N, N, W, C, W, C, C, C, C, C, C, C, W, C, W, N, N},
                {W, W, W, C, W, C, W, W, W, W, W, C, W, C, W, W, W},
                {W, C, C, C, C, C, C, C, C, C, C, C, C, C, C, C, W},
                {W, C, W, C, W, C, W, W, W, W, W, C, W, C, W, C, W},
                {W, S, C, C, W, C, C, C, I, C, C, C, W, C, C, M, W},
                {W, W, W, W, W, W, W, W, W, W, W, W, W, W, W, W, W}
        };
        this.blockingWall = false;
    }

    public Type[][] getMap() {
        return map;
    }

    public void delete(int i, int j) {
        this.map[i][j] = Type.N;
    }

    public boolean isAllPacGumAte() {
        for (Type[] y : map) {
            for (Type t : y) {
                if (t != Type.N && t != Type.W) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBlockingWall() {
        return blockingWall;
    }

    public void setBlockingWall(boolean blockingWall) {
        this.blockingWall = blockingWall;
        changeWall();
    }

    private void changeWall() {
        if (blockingWall) {
            map[7][2] = W;
            map[7][14] = W;
            map[7][4] = N;
            map[7][12] = N;
            map[7][6] = W;
            map[7][10] = W;
            map[1][4] = W;
            map[1][12] = W;
            map[13][4] = N;
            map[13][12] = N;
        } else {
            map[7][2] = N;
            map[7][14] = N;
            map[7][4] = W;
            map[7][12] = W;
            map[7][6] = N;
            map[7][10] = N;
            map[1][4] = N;
            map[1][12] = N;
            map[13][4] = W;
            map[13][12] = W;
        }
    }
}
