package ru.nsu.g.akononov.Arkanoid.view;

import ru.nsu.g.akononov.Arkanoid.model.components.Plank;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    public AppFrame(BallGUI ball, PlankGUI plank){
        setTitle("Arkanoid");
        setSize( 800, 800+25);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);

        setResizable(false);
        setVisible(true);
        setFocusable(true);

        add(ball);

        revalidate();
    }



}