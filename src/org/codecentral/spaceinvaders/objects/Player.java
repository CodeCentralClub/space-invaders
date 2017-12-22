package org.codecentral.spaceinvaders.objects;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A ship that that moves according to keyboard inputs.
 *
 * <p> This ship responds to left, right, "A", and "D" inputs.
 *
 * @version 1.0.0
 */
public class Player extends GameObject implements KeyListener {

    private static final int DEFAULT_WIDTH = 128;

    private static final int DEFAULT_HEIGHT = 128;

    /**
     * Creates a new player at the given x and y coordinates.
     *
     * @param x The initial x coordinate, starting from the left of screen
     * @param y The initial y coordinate, starting from the top of the screen
     */
    public Player(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onDraw(Graphics g) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO: Respond to KeyEvents
        switch (e.getKeyChar()) {
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
