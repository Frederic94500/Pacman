package fr.upec.pacman;

import java.awt.*;

public class Entity {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Direction direction;
    private Image mypic;         
    private Image [] img; 
    

    public Entity(int x, int y, int dx, int dy, Direction direction, Image [] img) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.direction = direction;
        this.img = img ;
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

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

	public Image [] getImg() {
		return img;
	}

	public void setImg(Image [] img) {
		this.img = img;
	}

	public Image getMypic() {
		return mypic;
	}

	public void setMypic(int i) {
		this.mypic = img [i];
	}
}
