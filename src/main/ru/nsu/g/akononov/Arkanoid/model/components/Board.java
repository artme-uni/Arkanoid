package ru.nsu.g.akononov.Arkanoid.model.components;

import java.awt.*;
import java.util.ArrayList;

public class Board extends ObjectArea{

    public ArrayList<Rectangle> barriers = new ArrayList<>();

    public Rectangle floor;

    public Board(int height, int width)
    {
        area = new Rectangle(0,0, width, height);

        int depth = 200;
        sidesInit(depth);
    }

    private void sidesInit(int depth)
    {
        barriers.clear();
        barriers.add(new Rectangle(0, -depth, getWidth(), depth));
        barriers.add(new Rectangle(-depth, 0, depth, getHeight()));
        barriers.add(new Rectangle(getWidth(), 0, depth, getHeight()));

        floor = new Rectangle(0, getHeight(), getWidth(), depth);
    }
}
