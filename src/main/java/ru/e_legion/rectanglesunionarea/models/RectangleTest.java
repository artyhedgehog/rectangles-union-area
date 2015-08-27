package ru.e_legion.rectanglesunionarea.models;

import ru.e_legion.rectanglesunionarea.models.Rectangle;

import static org.junit.Assert.*;

public class RectangleTest {

    @org.junit.Test
    public void testArea() throws Exception {
        Rectangle rectangle = new Rectangle(0, 2, -2, 0);
        assertEquals(4, rectangle.area());
    }

    @org.junit.Test
    public void testIntersection() throws Exception {
        Rectangle r1 = new Rectangle(-5, -3, 2, 1);
        Rectangle r2 = new Rectangle(3, 0, 6, 23);
        Rectangle r3 = new Rectangle(-4, -2, 3, 2);
        assertNull(r1.intersection(r2));
        assertEquals(r1.intersection(r3), new Rectangle(-4, -2, 2, 1));
        assertEquals(r1.intersection(r3), r3.intersection(r1));
    }
}