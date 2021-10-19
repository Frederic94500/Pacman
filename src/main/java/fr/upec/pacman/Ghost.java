package fr.upec.pacman;

import java.awt.*;

public class Ghost extends Entity {
    private Color color; //pas sûr que ça va être utile...

    public Ghost(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
}
