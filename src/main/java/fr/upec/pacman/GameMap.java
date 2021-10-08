package fr.upec.pacman;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameMap {
    private static final Type W = Type.W;
    private static final Type C = Type.C;
    private static final Type I = Type.I;
    private static final Type S = Type.S;
    private static final Type M = Type.M;
    private Map<Integer, Map<Integer, Type>> map;

    public Map<Integer, Map<Integer, Type>> getMap() {
        return map;
    }

    public GameMap() {
        final Type[][] gamemap = {
                {W, W, W, W, W, W, W, W, W, W, W},
                {W, C, C, C, C, W, C, C, C, C, W},
                {W, C, W, W, C, W, S, W, W, C, W},
                {W, C, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, I, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, M, C, C, W},
                {W, C, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, C, W},
                {W, W, W, W, W, W, W, W, W, W, W}};

        map = new HashMap<>();

        for (int i = 0; i < gamemap.length; i++) {
            var temp = new HashMap<Integer, Type>();
            for (int j = 0; j < gamemap[i].length; j++) {
                temp.put(j, gamemap[i][j]);
            }
            map.put(i, temp);
        }
    }

    public void deletePacGum(int x, int y){
        map.get(x).replace(y, Type.N);
    }
}
