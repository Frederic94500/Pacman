package fr.upec.pacman;

import fr.upec.pacman.EntityState.NormalGhost;

import java.awt.*;

public class Ghost extends Entity {
    public Ghost(int x, int y, Color color) {
        super(x, y, Direction.random(), color, new NormalGhost());
    }
}
