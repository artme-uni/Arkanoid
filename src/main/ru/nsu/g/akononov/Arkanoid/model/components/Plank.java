package ru.nsu.g.akononov.Arkanoid.model.components;

public class Plank {
    private int plankWidth;
    private int plankHeight;

    private int boardWidth;
    private int speedX = 1;

    private int x;
    private int y;

    public Plank(int x, int y, int plankWight, int plankHeight, int boardWight) {
        this.x = x;
        this.y = y;

        this.plankHeight = plankHeight;
        this.plankWidth = plankWight;

        this.boardWidth = boardWight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(boolean right)
    {
        x += (right ? 1 : -1)*speedX;
    }
}
