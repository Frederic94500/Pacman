package fr.upec.pacman;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private static final Type W = Type.W;
    private static final Type C = Type.C;
    private Map<Integer, Map<Integer, Type>> map;

    public Map<Integer, Map<Integer, Type>> getMap() {
        return map;
    }

    public GameMap() {
        final Type[][] gamemap = {
                {W, W, W, W, W, W, W, W, W, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, C, C, C, C, C, C, C, C, W},
                {W, W, W, W, W, W, W, W, W, W}};

        map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            var temp = new HashMap<Integer, Type>();
            for (int j = 0; j < 10; j++) {
                temp.put(j, gamemap[i][j]);
            }
            map.put(i, temp);
        }
    }
}
