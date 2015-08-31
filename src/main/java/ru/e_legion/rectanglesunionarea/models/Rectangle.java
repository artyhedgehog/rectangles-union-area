package ru.e_legion.rectanglesunionarea.models;

public class Rectangle {
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;


    public Rectangle(int x1, int y1, int x2, int y2) {
        super();
        this.left = Math.min(x1, x2);
        this.top = Math.min(y1, y2);
        this.right = Math.max(x1, x2);
        this.bottom = Math.max(y1, y2);
    }


    public int area() {
        return (right - left) * (bottom - top);
    }

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


    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

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
