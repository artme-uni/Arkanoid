package ru.nsu.g.akononov.Arkanoid.model.components;

import java.util.ArrayList;

public class Wall {
    ArrayList<Brick> bricks;

    int brickWidth;
    int brickHeight;

    Wall(Board board)
    {
        bricks = new ArrayList<>();
        setWall(board);
    }

    public void setWall(Board board)
    {
        brickWidth = 4 * board.height / 25;
    }
}
