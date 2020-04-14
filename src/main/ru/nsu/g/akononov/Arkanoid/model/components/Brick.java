package ru.nsu.g.akononov.Arkanoid.model.components;

import java.awt.*;

public class Brick extends ObjectArea{
    private boolean isDestroyed = false;

    Brick(int x, int y, int width, int height)
    {
        area = new Rectangle(x, y, width, height);
    }

    public void setDestroyed()
    {
        isDestroyed = true;
    }

    public boolean isDestroyed()
    {
        return isDestroyed;
    }
}
