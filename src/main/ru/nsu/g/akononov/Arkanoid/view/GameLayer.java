package ru.nsu.g.akononov.Arkanoid.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameLayer extends JPanel {

    GameLayer(PrintableObject ball,
              PrintableObject plank,
              ArrayList<PrintableObject> wall)
    {
        add(plank);
        setVisible(true);

        setBackground(Color.BLUE);

        add(ball);
        setVisible(true);

        for (var brick : wall)
        {
            add(brick);
            setVisible(true);
        }

        revalidate();
        repaint();
    }
}
