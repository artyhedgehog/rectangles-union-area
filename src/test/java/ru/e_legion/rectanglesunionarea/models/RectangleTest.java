package ru.e_legion.rectanglesunionarea.models;

import org.junit.Test;

import ru.e_legion.rectanglesunionarea.models.Rectangle;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testArea() throws Exception {
        Rectangle rectangle = new Rectangle(0, 2, -2, 0);
        assertEquals(4, rectangle.area());
    }

    @Test
    public void testIntersection() throws Exception {
        Rectangle r1 = new Rectangle(-5, -3, 2, 1);
        Rectangle r2 = new Rectangle(3, 0, 6, 23);
        Rectangle r3 = new Rectangle(-4, -2, 3, 2);
        assertNull(r1.intersection(r2));
        assertEquals(r1.intersection(r3), new Rectangle(-4, -2, 2, 1));
        assertEquals(r1.intersection(r3), r3.intersection(r1));
    }

    @Test
    public void testCoordinatesOrderAgnostic() throws Exception {
        Rectangle r1 = new Rectangle(0, 0, 1, 1);
        Rectangle r2 = new Rectangle(1, 0, 0, 1);
        Rectangle r3 = new Rectangle(0, 1, 1, 0);
        Rectangle r4 = new Rectangle(1, 1, 0, 0);
        assertEquals(r1, r2);
        assertEquals(r1, r3);
        assertEquals(r1, r4);
        assertEquals(0, r2.getLeft());
        assertEquals(0, r3.getTop());
        assertEquals(0, r4.getLeft());
        assertEquals(0, r4.getTop());
        assertEquals(1, r2.getRight());
        assertEquals(1, r3.getBottom());
        assertEquals(1, r4.getRight());
        assertEquals(1, r4.getBottom());
    }
}