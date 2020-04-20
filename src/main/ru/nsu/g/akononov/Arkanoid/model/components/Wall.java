package ru.nsu.g.akononov.Arkanoid.model.components;

import java.util.ArrayList;

public class Wall {
    public ArrayList<Brick> bricks;

    private final double PROPORTION = 5;

    int brickWidth;
    int offsetWidth;
    int brickHeight;
    int offsetHeight;

    public int currentBrickCount;

    public Wall(int countWidth, int countHeight, Board board) {
        bricks = new ArrayList<>();
        setWall(countWidth, countHeight, board);
    }

    public void restoreBricks()
    {
        currentBrickCount = bricks.size();
    }

    public void setWall(int countWidth, int countHeight, Board board) {

        brickWidth = (int) (board.getWidth() / (countWidth + (countWidth + 1) / PROPORTION));
        offsetWidth = (int) (brickWidth / PROPORTION);

        brickHeight = (int) ((board.getHeight() / 3) / (countHeight + (countHeight + 1) / PROPORTION));
        offsetHeight = (int) (brickHeight / PROPORTION);

        for (int i = 0; i < countHeight; i++) {
            int currentHeight = offsetHeight * (i + 1) + brickHeight * i;
            for (int j = 0; j < countWidth; j++) {
                bricks.add(new Brick(offsetWidth * (j + 1) + brickWidth * j, currentHeight, brickWidth, brickHeight));
            }
        }

        currentBrickCount = bricks.size();
    }

    public int getBrickHeight() {return brickHeight;}
    public int getBrickWidth() {return brickWidth;}
}