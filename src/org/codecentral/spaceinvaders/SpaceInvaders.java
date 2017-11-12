package org.codecentral.spaceinvaders;

import org.codecentral.spaceinvaders.objects.Alien;
import org.codecentral.spaceinvaders.objects.Barrier;
import org.codecentral.spaceinvaders.objects.Player;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nason Lewis, Carlos Rivera, Willie Chalmers III
 * @version 1.0.0
 */
public class SpaceInvaders extends Panel {

    private static final int DEFAULT_BARRIER_COUNT = 4;
    private static final int DEFAULT_ALIEN_COUNT = 4 * 11;
    private static final int DELAY = 20;

    /**
     * The initial width for the window upon launch.
     */
    private static final int DEFAULT_WIDTH = 1265;

    /**
     * The initial height for the window upon launch
     */
    private static final int DEFAULT_HEIGHT = 950;

    private Image image;
    private Graphics graphics;
    private Player player;
    private List<Alien> aliens = new ArrayList<>();
    private List<Barrier> barriers = new ArrayList<>();

    /**
     * Starts the program
     */
    public static void main(String[] args) {
        Frame f = new Frame();
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        SpaceInvaders window = new SpaceInvaders();
        window.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        window.init();
        f.add(window);
        f.pack();
        f.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        f.setVisible(true);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        if (image == null) {
            image = createImage(getWidth(), getHeight());
            graphics = image.getGraphics();
        }
        graphics.setColor(getBackground());
        graphics.fillRect(0, 0, getWidth(), getHeight());
        paint(graphics);
        g.drawImage(image, 0, 0, this);
    }


    @Override
    public void paint(Graphics g) {
        updateObjects(g);
        delay(DELAY);
        repaint();
    }

    /**
     * Initializes the game by loading and positioning {@link org.codecentral.spaceinvaders.objects.GameObject}s
     */
    private void init() {
        addKeyListener(player); // Lets player respond to keyboard input
        player = new Player(getWidth() / 2, getHeight() - 100);
        placeAliens();
        placeBarriers();
    }

    private void updateObjects(Graphics g) {
        player.onDraw(g);
        for (Alien alien : aliens) {
            alien.move();
            alien.onDraw(graphics);
        }
        barriers.forEach(barrier -> barrier.onDraw(g));
        // TODO: Use callback to handle collisions
    }

    private void placeBarriers() {
        for (int i = 0; i < DEFAULT_BARRIER_COUNT; i++) {
            barriers.add(new Barrier(200 + 300 * i, 700));
        }
    }

    private void placeAliens() {
        aliens.addAll(Stream.generate(() -> new Alien(100, 350)).limit(DEFAULT_ALIEN_COUNT)
                .collect(Collectors.toList()));
        // TODO: Populate the aliens with some loops
    }

    private static void delay(int n) {
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

