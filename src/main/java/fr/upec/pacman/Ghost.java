package fr.upec.pacman;

import fr.upec.pacman.EntityState.GhostState;

import java.awt.*;

public class Ghost extends Entity implements GhostState {
    public Ghost(int x, int y, Color color) {
        super(x, y, 4, 4, Direction.random(), color);
    }
}
