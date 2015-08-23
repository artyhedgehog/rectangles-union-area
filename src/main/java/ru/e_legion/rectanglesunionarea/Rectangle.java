package ru.e_legion.rectanglesunionarea;

public class Rectangle {
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;


    public Rectangle(int left, int top, int right, int bottom) {
        super();
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
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
