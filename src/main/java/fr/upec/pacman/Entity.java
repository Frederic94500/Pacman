package fr.upec.pacman;

import java.awt.*;

public class Entity {
    private int x;
    private int y;
    private Direction direction;
    private Color color;

    public Entity(int x, int y, Direction direction, Color color) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
