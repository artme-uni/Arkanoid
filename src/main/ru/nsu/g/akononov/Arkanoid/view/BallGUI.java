package ru.nsu.g.akononov.Arkanoid.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BallGUI extends JPanel {

    private Image image;

    private int x;
    private int y;

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private boolean visible;

    public BallGUI() {
        visible = true;

        try {
            loadImage("src/resources/ball.png");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void loadImage(String imageName) throws IOException {
        BufferedImage bufferedImage;
        ImageIcon imageIcon = new ImageIcon(imageName);
        image = imageIcon.getImage();
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0,this);
    }
}

