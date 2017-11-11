package org.codecentral.spaceinvaders;

import java.awt.*;

class barriers {
    int x = 200;
    int y = 700;

    public void draw(Graphics g) {
        Color Green = new Color(0, 255, 0);
        g.setColor(Green);
        g.fillRect(x, y, 30, 70);
        g.fillRect(x, y, 70, 30);
        g.fillRect(x + 70, y, 30, 70);

        g.fillRect(x + 300, y, 30, 70);
        g.fillRect(x + 300, y, 70, 30);
        g.fillRect(x + 370, y, 30, 70);

        g.fillRect(x + 600, y, 30, 70);
        g.fillRect(x + 600, y, 70, 30);
        g.fillRect(x + 670, y, 30, 70);
    }
}
