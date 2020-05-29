package ru.nsu.g.akononov.arkanoid.model.components;

import java.awt.*;

public class Plank extends ObjectArea{
    private int boardWidth;
    private int speedX = 25;

    public Plank(int x, int y, int plankWight, int plankHeight, int boardWight) {

        area = new Rectangle(x, y, plankWight, plankHeight);
        boardWidth = boardWight;
    }

    public void move(boolean isRight) {
        if (((area.x + (isRight ? 1 : -1) * speedX) >= 0) && ((area.x + (isRight ? 1 : -1) * speedX + area.width) <  boardWidth)) {
            area.x += (isRight ? 1 : -1) * speedX;
        }
    }

    public void setSpeedX(int speedX)
    {
        this.speedX = speedX;
    }
}
