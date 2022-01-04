package fr.upec.pacman;

import java.awt.*;

public class Ghost extends Entity {
    public Ghost(int x, int y, Color color) {
        super(x, y, 4, 4, Direction.random(), color);
    }
}
