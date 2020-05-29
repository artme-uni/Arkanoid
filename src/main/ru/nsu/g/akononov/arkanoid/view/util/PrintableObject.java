package ru.nsu.g.akononov.arkanoid.view.util;

import javax.swing.*;
import java.awt.*;

public class PrintableObject extends JPanel {

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

    public int getHeight() {
        return area.height;
    }

    public int getWidth() {
        return area.width;
    }

    public PrintableObject(Image image, int height, int width) {

        this.area = new Rectangle(0, 0, width, height);
        this.image = image.getScaledInstance(area.width, area.height, Image.SCALE_AREA_AVERAGING);

        setVisible(true);
    }

    public void editImage(Image image) {
        this.image = image.getScaledInstance(area.width, area.height, Image.SCALE_AREA_AVERAGING);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

