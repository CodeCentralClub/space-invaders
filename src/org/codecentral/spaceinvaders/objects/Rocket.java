package org.codecentral.spaceinvaders.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Rocket extends GameObject {

    /**
     * The amount of pixels to move every time {@link #move()} is called.
     */
    private int speed = 10;

    /**
     * Creates a new rocket at the given coordinates.
     *
     * @param x The initial x coordinate, starting from the left of screen
     * @param y The initial y coordinate, starting from the top of the screen
     */
    public Rocket(int x, int y) {
        super(x, y);
    }

    @Override
    public void onDraw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(getX(), getY(), 3, 10);
    }

    public void move() {
        // TODO: Check for collisions
        setY(getY() + speed); // Simply move upwards
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    int getSpeed() {
        return speed;
    }
}
