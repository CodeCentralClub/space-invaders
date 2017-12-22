package org.codecentral.spaceinvaders;

import org.codecentral.spaceinvaders.objects.Alien;
import org.codecentral.spaceinvaders.objects.Barrier;
import org.codecentral.spaceinvaders.objects.Player;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;

/**
 * @author Nason Lewis, Carlos Rivera, Willie Chalmers III
 * @version 1.0.0
 */
public class SpaceInvaders extends Panel {

    private static final String NAME = "Space Invaders";

    private static final int DEFAULT_BARRIER_COUNT = 4;
    private static final int DEFAULT_ALIEN_COUNT = 4 * 11;
    private static final int DELAY = 20;

    private Player player;
    private List<Alien> aliens = new ArrayList<>();
    private List<Barrier> barriers = new ArrayList<>();

    /**
     * Starts the program
     */
    public static void main(String[] args) {
        JFrame f = new JFrame(NAME);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        SpaceInvaders game = new SpaceInvaders();
        f.add(game);
        game.init();
        f.pack();
        f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screenSize.width - 100, screenSize.height - 100);
        f.setVisible(true);
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
            alien.onDraw(getGraphics());
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

