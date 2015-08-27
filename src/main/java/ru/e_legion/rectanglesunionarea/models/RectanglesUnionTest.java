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
}