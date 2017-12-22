package org.codecentral.spaceinvaders.objects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * An alien enemy that moves towards the player.
 *
 * @version 1.0.0
 */
public class Alien extends GameObject {

    private static final int DEFAULT_WIDTH = 500;

    private static final int DEFAULT_HEIGHT = 500;

    /**
     * Creates a new alien at the given coordinates.
     *
     * @param x The initial x coordinate, starting from the left of screen
     * @param y The initial y coordinate, starting from the top of the screen
     */
    public Alien(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void onDraw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(getX(), getY(), 31, 30);
        g.fillRect(getX(), getX() + 40, 31, 30);
        g.fillRect(getX(), getY() + 80, 31, 30);
        g.fillRect(getX(), getY() + 120, 31, 30);
        g.fillRect(getX(), getY() + 160, 31, 30);
        // TODO: Draw properly
    }

    /**
     * Moves this alien right until collision, down, left until collision, and repeats.
     */
    public void move() {
        /* TODO: Make a loop that checks for boundaries and keeps moving until it collides
                  with them */
    }
}
