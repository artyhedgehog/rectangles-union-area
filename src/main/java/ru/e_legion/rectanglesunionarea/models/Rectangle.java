package ru.e_legion.rectanglesunionarea.models;

/**
 * Model of rectangle with sides parallel to axis.
 */
public class Rectangle {
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;


    /**
     * Construct rectangle via to points coordinates.
     * Points can be of any opposite rectangle angles.
     * @param x1 First angle abscissa.
     * @param y1 First angle ordinate.
     * @param x2 Second angle abscissa.
     * @param y2 Second angle ordinate.
     */
    public Rectangle(int x1, int y1, int x2, int y2) {
        super();
        this.left = Math.min(x1, x2);
        this.top = Math.min(y1, y2);
        this.right = Math.max(x1, x2);
        this.bottom = Math.max(y1, y2);
    }


    /**
     * Calculate if has not yet and get an area of current rectangle.
     * @return The rectangle area.
     */
    public int area() {
        if (-1 == area) {
            area = (right - left) * (bottom - top);
        }
        return area;
    }
    private int area = -1;

    /**
     * Create and get rectangle which represents and intersection of the current
     * rectangle with another rectangle given as an argument.
     * @param other Rectangle to find intersection with.
     * @return Rectangle which acts as found intersection. If given rectangles
     *          have no intersection between each other, a zero-sized rectangle
     *          will be returned.
     */
    public Rectangle intersection(Rectangle other) {
        if (!intersectsWith(other)) {
            return null;
        }

        int left, top, right, bottom;
        left = includesX(other.getLeft()) ? other.getLeft() : getLeft();
        top = includesY(other.getTop()) ? other.getTop() : getTop();
        right = includesX(other.getRight()) ? other.getRight() : getRight();
        bottom = includesY(other.getBottom()) ? other.getBottom() : getBottom();
        return new Rectangle(left, top, right, bottom);
    }


    /**
     * Compare if the given rectangle is equivalent to the current one.
     * @param otherObject Another rectangle to find intersection with.
     * @return True if the given object is a rectangle model and has the same
     *          coordinates.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Rectangle)) {
            return false;
        }
        Rectangle otherRectangle = (Rectangle) otherObject;
        return getLeft() == otherRectangle.getLeft()
                && getTop() == otherRectangle.getTop()
                && getRight() == otherRectangle.getRight()
                && getBottom() == otherRectangle.getBottom();
    }

    /**
     * @return Abscissa of the left side.
     */
    public int getLeft() {
        return left;
    }

    /**
     * @return Top side ordinate.
     */
    public int getTop() {
        return top;
    }

    /**
     * @return Abscissa of the right side.
     */
    public int getRight() {
        return right;
    }

    /**
     * @return Bottom side ordinate.
     */
    public int getBottom() {
        return bottom;
    }


    private boolean includesX(int x) {
        return (getLeft() <= x && x <= getRight());
    }

    private boolean includesY(int y) {
        return (getTop() <= y && y <= getBottom());
    }

    private boolean intersectsWith(Rectangle other) {
        return (includesX(other.getLeft()) || includesX(other.getRight()))
                && (includesY(other.getTop()) || includesY(other.getBottom()));
    }
}
