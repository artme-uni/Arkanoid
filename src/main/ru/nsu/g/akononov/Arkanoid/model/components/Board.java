package ru.nsu.g.akononov.Arkanoid.model.components;

import java.awt.*;
import java.util.ArrayList;

public class Board {
    public int height;
    public int width;

    public ArrayList<Rectangle> sides = new ArrayList<>();

    public Board(int height, int width)
    {
        this.height = height;
        this.width = width;

        sides.add(new Rectangle(0, -100, width, 100));
        sides.add(new Rectangle(-100, 0, 100, height));
        sides.add(new Rectangle(0, height, width, 100));
        sides.add(new Rectangle(width, 0, 100, height));
    }
}
