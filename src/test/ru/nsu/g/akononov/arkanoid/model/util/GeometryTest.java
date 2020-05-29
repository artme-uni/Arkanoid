package ru.nsu.g.akononov.arkanoid.model.util;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeometryTest {

    @Test
    public void addCorners() {
        Map<Point, corner> map = new HashMap<>();
        Geometry.addCorners(map, new Rectangle(0, 0, 100, 50));
        assertEquals(4, map.size());
    }

    @Test
    public void nearbyPoints() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(0, 10));
        list.add(new Point(10, 0));
        list.add(new Point(0, 0));
        Geometry.nearbyPoints(list, new Point(10, 10));
        assertEquals(2, list.size());
    }

    @Test
    public void minDistance() {
        double min1 = Geometry.minDistance(new Point(-10, -10), new Point(10, -10), new Point(30, -10));
        double min2 = Geometry.minDistance(new Point(-10, -10), new Point(10, -10), new Point(0, 0));
        assertEquals(20, (int)min1);
        assertEquals(10, (int)min2);
    }

    @Test
    public void defineEdge() {
        assertEquals(edge.LEFT, Geometry.defineEdge(corner.LB, corner.LU));
    }

    @Test
    public void isIntersect() {
        Rectangle a = new Rectangle(0, 0, 10, 10);
        Rectangle b = new Rectangle(10, 0, 10, 10);
        assertTrue(Geometry.isIntersect(a, b));
    }
}