package fr.upec.pacman;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class GameMap {
    private static final Type W = Type.W; // W = WALL
    private static final Type C = Type.C; // C = CLASSIC
    private static final Type I = Type.I; // I = INVISIBLE
    private static final Type S = Type.S; // S = SUPERPOWER
    private static final Type M = Type.M; // N = NOTHING
    private static final Type P = Type.M; // P = PACMAN
    private static final Type G = Type.M; // G = GHOST
    
    
    
    private Type [] [] map; // Terrain 
    
    public GameMap() {
        map = new Type [10][10] ; 
        for (int i = 0 ; i < map.length ; i++){
        		for (int j = 0 ; j< map[i].length ; j++) {
        			// Emplacement du packman 
        			if (i == 4 && j == 4) {map [i][j] = P ;}
        			
        			else {map [i][j] = C ; }
        		}
        }

        }
    
    
    public Type [] [] getMap() {
        return map;
    }
    
    public void setMap(Type [] [] tab) {
         map = tab;
    }

    
}
