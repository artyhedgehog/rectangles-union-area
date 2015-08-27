package ru.e_legion.rectanglesunionarea.models;

import java.util.ArrayList;
import java.util.List;

public class RectanglesUnion {
    private int area;
    private List<Rectangle> rectangles = new ArrayList<Rectangle>(100);

    public int area() {
        return area;
    }

    public RectanglesUnion add(Rectangle additional) {
        RectanglesUnion overlap = new RectanglesUnion();
        List<Rectangle> replaced = new ArrayList<Rectangle>(rectangles.size());
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
