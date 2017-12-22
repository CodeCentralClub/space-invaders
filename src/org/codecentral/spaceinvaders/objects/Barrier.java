package org.codecentral.spaceinvaders.objects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A barrier that blocks {@link Rocket}s from passing.
 *
 * @version 1.0.0
 */
public class Barrier extends GameObject {

    private static final int DEFAULT_WIDTH = 70;

    private static final int DEFAULT_HEIGHT = 100;

    /**
     * Creates a new barrier at the given x and y coordinates.
     *
     * @param x The initial x coordinate, starting from the left of screen
     * @param y The initial y coordinate, starting from the top of the screen
     */
    public Barrier(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onDraw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(getX(), getY(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
        g.fillRect(getX() + DEFAULT_WIDTH, getY(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
