package ru.nsu.g.akononov.Arkanoid.model.components;

import java.awt.*;

public class Brick {
    private boolean isVisible = true;
    public Rectangle area;

    Brick(int x, int y, int width, int height)
    {
        area = new Rectangle(x, y, width, height);
    }
}
