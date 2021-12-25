package fr.upec.pacman;

public enum Direction {
    UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0), VOID(0, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Direction random() {
        switch ((int) (Math.random() * 4)) {
            case 0:
                return UP;
            case 1:
                return DOWN;
            case 2:
                return LEFT;
            case 3:
                return RIGHT;
        }
        return null;
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }
}
