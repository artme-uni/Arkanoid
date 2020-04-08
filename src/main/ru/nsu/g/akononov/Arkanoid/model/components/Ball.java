package ru.nsu.g.akononov.Arkanoid.model.components;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;

import ru.nsu.g.akononov.Arkanoid.model.util.*;

public class Ball {
    private Rectangle area;

    private Board board;

    private int speedX = 1;
    private int speedY = 1;
    private boolean right = true;
    private boolean up = false;

    public Ball(int x, int y, int radius, Board board) {

        area = new Rectangle(x-radius, y-radius, radius * 2, radius * 2);

        this.board = board;
    }

    public int getX() {
        return area.x;
    }

    public int getY() {
        return area.y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void move() {

        for(var obj : board.sides)
        {
            reflection(obj);
        }

        area.x += (right ? 1 : -1) * speedX;
        area.y += (up ? 1 : -1) * speedY;
    }

    private void reflection(Rectangle rectangle)
    {
        edge state = contains(rectangle);

        if(state == edge.OUTSIDE)
            return;

        if(state == edge.LEFT || state == edge.RIGHT) {
            right = !right;
        }

        if(state == edge.UP || state == edge.DOWN) {
            up = !up;
        }
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