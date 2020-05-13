package ru.nsu.g.akononov.Arkanoid.model.components;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;

import ru.nsu.g.akononov.Arkanoid.model.util.*;

public class Ball extends ObjectArea {

    private int speedX = 1;
    private int speedY = 1;
    private boolean right = true;
    private boolean down = false;

    private int shift = 25;

    public Ball(int x, int y, int radius) {
        area = new Rectangle(x-radius, y-radius, radius * 2, radius * 2);
    }

    public int getRadius() { return area.height/2;}

    public void setSpeedX(int speedX, double proportion) {
        if(speedX < 0)
            right = false;

        this.speedX = (int) (Math.abs(speedX)*proportion);
    }

    public void setSpeedY(int speedY, double proportion) {
        this.speedY = (int) (Math.abs(speedY) * proportion);
    }

    public void move() {
        area.x += (right ? 1 : -1) * speedX;
        area.y += (down ? 1 : -1) * speedY;
    }

    public void moveBack() {
        area.x -= (right ? 1 : -1) * speedX;
        area.y -= (down ? 1 : -1) * speedY;
    }

    public void setShift(int shift)
    {
        this.shift = shift;
    }

    public void shift(boolean isRight, int boardWidth)
    {
        if (((area.x + (isRight ? 1 : -1) * shift - getWidth()/2) >= 0) && ((area.x + (isRight ? 1 : -1) * shift + 1.5 * area.width) <  boardWidth)) {
            area.x += (isRight ? 1 : -1) * shift;
        }
    }

    public void setDefaultDirection()
    {
        right = true;
        down = false;
    }

    public boolean reflection(Rectangle rectangle)
    {
        edge state = contains(rectangle);

        if(state == edge.OUTSIDE) {
            return false;
        }

        if(state == edge.LEFT && right){
            right = false;
        }

        if(state == edge.RIGHT && !right){
            right = true;
        }

        if(state == edge.UP && down){
            down = false;
        }

        if(state == edge.DOWN && !down){
            down = true;
        }

        return true;
    }

    public boolean reflectBrick(Brick brick)
    {
        if(reflection(brick.area))
        {
            brick.setDestroyed();
            return true;
        }

        return false;
    }

    private edge contains(Rectangle rectangle) {
        //Проверяем, пересекаются ли прямоугольник и квадрат, в который вписан круг
        if(!Geometry.isIntersect(area, rectangle))
            return edge.OUTSIDE;

        Point center = new Point(area.x + area.width / 2, area.y + area.height / 2);

        Map<Point, Double> lengths = new HashMap<>();
        Map<Point, corner> corners = new HashMap<>();

        //Добавляем все углы
        Geometry.addCorners(corners, rectangle);

        //Находим расстояние от углов до цента окружности
        for (var p : corners.keySet()) {
            lengths.put(p, Point2D.distance(center.x, center.y, p.x, p.y));
        }

        //Находим ближайший угол
        ArrayList<Map.Entry<Point, Double>> e = new ArrayList<>(lengths.entrySet());
        e.sort((o1, o2) -> (int) (o1.getValue() - o2.getValue()));
        Point nearest = e.get(0).getKey();

        //Находим две соседние точки угла
        ArrayList<Point> nearby = new ArrayList<>(corners.keySet());
        Geometry.nearbyPoints(nearby, nearest);

        //Считаем расстояние до сторон, которые они образуют с углом
        double dist1 = Geometry.minDistance(nearby.get(0), nearest, center);
        double dist2 = Geometry.minDistance(nearby.get(1), nearest, center);

        double minDist = Math.min(dist1, dist2);
        if(minDist > ((double)area.height)/2)
            return edge.OUTSIDE;

        //Выбираем ближайшую сторону
        Point withNearest;
        if(dist1 <= dist2)
            withNearest = nearby.get(0);
        else
            withNearest = nearby.get(1);

        corner a = corners.get(nearest);
        corner b = corners.get(withNearest);

        return Geometry.defineEdge(a, b);
    }
}