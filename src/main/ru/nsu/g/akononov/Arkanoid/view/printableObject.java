package ru.nsu.g.akononov.Arkanoid.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class printableObject extends JPanel {

    private Image image;

    private Rectangle area;

    @Override
    public int getX() {
        return area.x;
    }

    public void setX(int x) {
        this.area.x = x;
    }

    @Override
    public int getY() {
        return area.y;
    }

    public void setY(int y) {
        this.area.y = y;
    }

    public printableObject(String imageName, int height, int width) {

        this.area = new Rectangle(0, 0, width, height);

        loadImage(imageName);

        setVisible(true);
    }

    protected void loadImage(String imageName) {
        ImageIcon sourceImage = new ImageIcon(imageName);
        ImageIcon imageIcon = new ImageIcon(sourceImage.getImage().getScaledInstance(area.width, area.height, Image.SCALE_DEFAULT));
        image = imageIcon.getImage();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

