package ru.e_legion.rectanglesunionarea.models;

import org.junit.Test;

import ru.e_legion.rectanglesunionarea.models.Rectangle;
import ru.e_legion.rectanglesunionarea.models.RectanglesUnion;

import static org.junit.Assert.*;

public class RectanglesUnionTest {

    @Test
    public void testArea() throws Exception {
        RectanglesUnion union = new RectanglesUnion();
        union.add(new Rectangle(0, 0, 3, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 6, 3))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(2, 0, 5, 2))
             .add(new Rectangle(1, 1, 4, 3));
        assertEquals(17, union.area());
    }

    @Test
    public void testHighload() throws Exception {
        final Runtime runtime = Runtime.getRuntime();
        RectanglesUnion union = new RectanglesUnion();
        long usedMemoryMB;
        int x1, y1, x2, y2;
        for (int i = 0; i < 100; ++i) {
            x1 = i * 100 - 10_000;
            y1 = -10_000;
            x2 = (i + 1) * 100;
            y2 = 10_000;
            union.add(new Rectangle(x1, y1, x2, y2));
            usedMemoryMB = (runtime.totalMemory() - runtime.freeMemory())
                    / 1024 / 1024;
            assertTrue(usedMemoryMB < 16);
        }
        assertEquals(400_000_000, union.area());
    }
}