package org.codecentral.spaceinvaders.objects;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Objects;

/**
 * The base class for all displayable on-screen components.
 */
abstract class GameObject {

    private Point position;

    /**
     * Creates a new game object at the given coordinates.
     *
     * @param x The initial x coordinate, starting from the left of screen
     * @param y The initial y coordinate, starting from the top of the screen
     */
    public GameObject(int x, int y) {
        this(new Point(x, y));
    }

    public GameObject(Point position) {
        this.position = position;
    }

    public int getX() {
        return (int) position.getX();
    }

    public int getY() {
        return (int) position.getY();
    }

    public void setX(double x) {
        position.setLocation(x, getY());
    }

    public void setY(double y) {
        position.setLocation(getX(), y);
    }

    /**
     * Requests this game object to draw itself onto the screen.
     *
     * @param g The root graphics object where all images are drawn
     */
    public abstract void onDraw(Graphics g);

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    /**
     * Returns true if the given object has the same X and Y coordinates as this.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameObject)) {
            return false;
        }
        GameObject object = (GameObject) o;
        return (object.getX() == getX()) && (object.getY() == getY());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[x=" + getX() + ",y=" + getY() + "]";
    }

    public enum Direction {
        LEFT, RIGHT, UP, DOWN;
    }
}