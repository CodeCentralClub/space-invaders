package org.codecentral.spaceinvaders.objects;

/**
 * A listener that takes action when a collision between two {@link GameObject}s is about to occur.
 */
public interface CollisionDetector {

    /**
     * Checks if two {@link GameObject}s are touching (adjacent) or are intersecting each other.
     *
     * @return Whether or not the first game object is intersecting the second
     */
    default boolean checkCollision(GameObject first, GameObject second) {
        double firstX = first.getX();
        double firstY = first.getY();
        return (second.getX() + second.getWidth() > firstX &&
                second.getY() + second.getHeight() > firstY &&
                second.getX() < firstX + first.getWidth() &&
                second.getY() < firstY + first.getHeight());
    }

    /**
     * @see #checkCollision(GameObject, GameObject)
     */
    boolean checkCollision(GameObject object);
}
