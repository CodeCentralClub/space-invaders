package org.codecentral.spaceinvaders;

import java.awt.*;

public class Rocket {
    int x = 100000;
    int y = 100000;

    public void draw(Graphics g) {
        Color White = new Color(255, 255, 255);
        g.setColor(White);
        g.fillOval(x, y -= 25, 3, 10);
    }
}
