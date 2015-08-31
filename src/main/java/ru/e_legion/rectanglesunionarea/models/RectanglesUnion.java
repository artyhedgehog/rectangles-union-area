package ru.e_legion.rectanglesunionarea.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Union of the given rectangles models.
 * Containing rectangles are to be sequentially added.
 */
public class RectanglesUnion {
    private int area;
    private List<Rectangle> rectangles = new ArrayList<>(100);

    /**
     * Get accumulated area.
     * @return Summary area of the figure containing all the given rectangles.
     */
    public int area() {
        return area;
    }

    /**
     * Add a rectangle to the resulting unit. Area is appended with each added
     * rectangle so it is an incremental process.
     * @param additional A rectangle to extend the union.
     * @return Current object for the method call chaining.
     */
    public RectanglesUnion add(Rectangle additional) {
        RectanglesUnion overlap = new RectanglesUnion();
        List<Rectangle> replaced = new ArrayList<>(rectangles.size());
        for (Rectangle present : rectangles) {
            if (present.equals(additional)) {
                // New rectangle already presents in union - nothing to do
                return this;
            }
            Rectangle intersection = present.intersection(additional);
            if (null == intersection) {
                // No overlap to add
                continue;
            }
            if (intersection.equals(additional)) {
                // Some old rectangle already contains the new one fully
                return this;
            }
            if (intersection.equals(present)) {
                // The new rectangle fully replaced an old one
                replaced.add(present);
            }
            overlap.add(intersection);
        }
        area += additional.area() - overlap.area();
        // Replaced rectangles can be removed
        rectangles.removeAll(replaced);
        rectangles.add(additional);
        return this;
    }
}
