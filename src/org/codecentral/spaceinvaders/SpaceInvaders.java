package org.codecentral.spaceinvaders;

import java.awt.*;

/**
 * @author Nason Lewis, Carlos Rivera
 */
public class SpaceInvaders extends Panel {

    private Image image;
    private Graphics graphics;
    private Player player = new Player();
    private Rocket b = new Rocket();
    private Alien a = new Alien();

    public static void main(String[] args) {
        Frame f = new Frame();
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        SpaceInvaders window = new SpaceInvaders();
        window.setSize(1000, 650);
        f.add(window);
        f.pack();
        window.init();
        f.setSize(1265, 950);
        f.setVisible(true);
    }

    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            graphics = image.getGraphics();
        }
        graphics.setColor(getBackground());

        graphics.fillRect(0, 0, getWidth(), this.getHeight());
        paint(graphics);
        g.drawImage(image, 0, 0, this);
    }


    public void init() {

    }

    public void paint(Graphics g) {
        player.background(g);
        a.draw(g);
        a.death(b);
        player.death(a, g);
        a.move(g);
        a.shoot(g);
        a.wall();
        player.wall();
        b.draw(g);
        player.move(b);
        player.draw(g);
        delay(20);
        repaint();
    }


    public static void delay(int n) {
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n) {
            endDelay = System.currentTimeMillis();
        }
    }

    @Override
    public boolean mouseMove(Event e, int x, int y) {
        return InputHandler.mouseUpdate(x, y);
    }

    @Override
    public boolean mouseDrag(Event e, int x, int y) {
        return InputHandler.mouseUpdate(x, y);
    }

    @Override
    public boolean mouseDown(Event e, int x, int y) {
        return InputHandler.mouseChange(e, true);
    }

    @Override
    public boolean mouseUp(Event e, int x, int y) {
        return InputHandler.mouseChange(e, false);
    }

    @Override
    public boolean keyDown(Event e, int key) {
        return InputHandler.keyChange(e, key, true);
    }

    @Override
    public boolean keyUp(Event e, int key) {
        return InputHandler.keyChange(e, key, false);
    }

}

