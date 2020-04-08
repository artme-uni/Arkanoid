package ru.nsu.g.akononov.Arkanoid.model.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class Geometry {

    //Добавляет в список все углы Rectangle ввиде Point
    static public void addCorners(Map<Point, corner> corners, Rectangle rectangle)
    {
        corners.put(new Point(rectangle.x, rectangle.y), corner.LU);
        corners.put(new Point(rectangle.x + rectangle.width, rectangle.y), corner.RU);
        corners.put(new Point(rectangle.x, rectangle.y + rectangle.height), corner.LB);
        corners.put(new Point(rectangle.x + rectangle.width, rectangle.y + rectangle.height), corner.RB);
    }

    //Оставлет в списке только соседние точки
    static public void nearbyPoints(ArrayList<Point> corners, Point current)
    {
        for(int i = 0; i < corners.size(); i++)
        {
            if(corners.get(i).x != current.x && corners.get(i).y != current.y) {
                corners.remove(i);
                break;
            }

        }

        for(int i = 0; i < corners.size(); i++)
        {
            if(corners.get(i).x == current.x && corners.get(i).y == current.y) {
                corners.remove(i);
                break;
            }
        }
    }

    //Находит минимальное расстояние от точки B до отрезка A
    static public double minDistance(Point A1, Point A2, Point B)
    {
        int dx = A1.x - A2.x;
        int dy = A1.y - A2.y;

        double t = ((double) ((B.x - A2.x) * dx + (B.y - A2.y) * dy) / (Math.pow(dx, 2) + Math.pow(dy, 2)));
        if (t < 0) t = 0;
        if (t > 1) t = 1;

        return Math.sqrt(Math.pow(A2.x - B.x + dx*t, 2) + Math.pow(A2.y - B.y + dy*t, 2));
    }

    //Определяет грань по двум точкам
    static public edge defineEdge(corner a, corner b)
    {
        if(a == corner.LU && b == corner.RU || a == corner.RU && b == corner.LU)
        {
            return edge.UP;
        }

        if(a == corner.RU && b == corner.RB || a == corner.RB && b == corner.RU)
        {
            return edge.RIGHT;
        }

        if(a == corner.RB && b == corner.LB || a == corner.LB && b == corner.RB)
        {
            return edge.DOWN;
        }

        if(a == corner.LB && b == corner.LU || a == corner.LU && b == corner.LB)
        {
            return edge.LEFT;
        }

        return edge.OUTSIDE;
    }

    //проверяет, пересекаются ли два прямоугольника
    static public boolean isIntersect(Rectangle a, Rectangle b)
    {
        if (!(a.y < b.y + b.height || a.y + a.height > b.y ||
                a.x + a.width < b.x || a.x > b.x + b.width)) {
            return false;
        }

        return true;
    }
}