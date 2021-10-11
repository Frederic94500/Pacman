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
    private static final Type P = Type.P; // P = PACMAN
    private static final Type Gr = Type.Gr; // G = GHOST
    private static final Type Gb = Type.Gb; // G = GHOST
    private static final Type Go = Type.Go; // G = GHOST
    private static final Type Gp = Type.Gp; // G = GHOST
    
    
    
    private Type [] [] map; // Terrain 
    
    public GameMap() {
    
    	// hautteur : i  largeur : j
    	
    	map = new Type [10][10] ; 
        for (int i = 0 ; i < map.length ; i++){
        		for (int j = 0 ; j< map[i].length ; j++) {
        			// Emplacement du packman 
        			if (i == 4 && j == 4) {map [i][j] = P ;}	
        			else {map [i][j] = C ; }
        		}
        		// place initiale des fantomes :
        	map [1][2] = Gr ;
        	map [1][8] = Go ;
        	map [8][8] = Gp ;
        	map [8][2] = Gb ;
        	
        	
        	   // les murs :
        	map [0][0] = W ; map [0][1] = W ; map [1][0] = W ; 
        	map [8][0] = W ; map [9][0] = W ; map [9][1] = W ;
        	map [0][8] = W ; map [0][9] = W ; map [1][9] = W ;
        	map [8][9] = W ; map [9][9] = W ; map [9][8] = W ;
        	 
        	
        }

        }
    
    
    public Type [] [] getMap() {
        return map;
    }
    
    public void setMap(Type [] [] tab) {
         map = tab;
    }

    
}
