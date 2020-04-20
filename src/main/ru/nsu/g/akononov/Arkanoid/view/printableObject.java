package ru.nsu.g.akononov.Arkanoid.view;

import javax.imageio.ImageIO;
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
        try {
            Image img = ImageIO.read(this.getClass().getResourceAsStream(imageName));
            image = img.getScaledInstance(area.width, area.height, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

