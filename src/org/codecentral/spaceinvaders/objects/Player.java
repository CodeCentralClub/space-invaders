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

//    int x = 550;
//    int x2 = 900;
//    int x3 = 800;
//    int x4 = 700;
//    int y = 850;
//    int y2 = 50;
//    int y3 = 50;
//    int y4 = 50;
//    int e = 0;
//
//    public void death(Alien a, Graphics g) {
//
//        if (a.ya >= y - 200 && a.ya <= y - 169 && a.xa >= x - 400 && a.xa <= x + 100) {
//            x += 10000;
//            x2 = 550;
//            y2 = 850;
//            e = 1;
//
//            if (e == 1) {
//                if (a.ya >= y - 200 && a.ya <= y - 169 && a.xa >= x - 400 && a.xa <= x + 100) {
//                    x2 += 10000;
//                    x3 -= 800;
//                    y3 -= 200;
//                    x3 += 550;
//                    y3 += 850;
//                    e = 2;
//                }
//            }
//            if (e == 2) {
//                if (a.ya >= y - 200 && a.ya <= y - 169 && a.xa >= x - 400 && a.xa <= x + 100) {
//                    x3 += 10000;
//                    x4 -= 800;
//                    y4 -= 200;
//                    x4 += 550;
//                    y4 += 850;
//                    e = 3;
//                }
//            }
//            if (e == 3) {
//                if (a.ya >= y - 200 && a.ya <= y - 169 && a.xa >= x - 400 && a.xa <= x + 100) {
//                    x4 += 10000;
//                    e = 4;
//                    g.setFont(new Font("Courier", Font.PLAIN, 800));
//                    g.drawString("GAME OVER", 100, 500);
//                }
//            }
//        }
//    }
//
//    public void background(Graphics g) {
//        Color Black = new Color(0, 0, 0);
//        g.setColor(Black);
//        g.fillRect(0, 0, 1300, 1000);
//    }
//
//    public void draw(Graphics g) {
//        Color Green = new Color(0, 255, 0);
//        g.setColor(Green);
//        g.fillRect(x, y, 70, 30);
//        g.fillRect(x + 33, y - 20, 6, 37);
//
//        Color Blue = new Color(0, 0, 255);
//        g.setColor(Blue);
//        g.fillRect(x2, y2, 70, 30);
//        g.fillRect(x2 + 33, y2 - 20, 6, 37);
//
//        Color Red = new Color(255, 0, 0);
//        g.setColor(Red);
//        g.fillRect(x3, y3, 70, 30);
//        g.fillRect(x3 + 33, y3 - 20, 6, 37);
//
//        Color White = new Color(255, 255, 255);
//        g.setColor(White);
//        g.fillRect(x4, y4, 70, 30);
//        g.fillRect(x4 + 33, y4 - 20, 6, 37);
//    }
//
//    public void move(Rocket b) {
//        if (e == 0) {
//            if (InputHandler.RIGHT) {
//                x += 15;
//
//            }
//            if (InputHandler.LEFT) {
//                x -= 15;
//            }
//            if (InputHandler.D) {
//                x += 15;
//            }
//            if (InputHandler.A) {
//                x -= 15;
//            }
//        }
//        if (e == 1) {
//            if (InputHandler.RIGHT) {
//                x2 += 15;
//
//            }
//            if (InputHandler.LEFT) {
//                x2 -= 15;
//            }
//            if (InputHandler.D) {
//                x2 += 15;
//            }
//            if (InputHandler.A) {
//                x2 -= 15;
//            }
//        }
//        if (e == 2) {
//            if (InputHandler.RIGHT) {
//                x3 += 15;
//
//            }
//            if (InputHandler.LEFT) {
//                x3 -= 15;
//            }
//            if (InputHandler.D) {
//                x3 += 15;
//            }
//            if (InputHandler.A) {
//                x3 -= 15;
//            }
//        }
//        if (e == 3) {
//            if (InputHandler.RIGHT) {
//                x4 += 15;
//
//            }
//            if (InputHandler.LEFT) {
//                x4 -= 15;
//            }
//            if (InputHandler.D) {
//                x4 += 15;
//            }
//            if (InputHandler.A) {
//                x4 -= 15;
//            }
//        }
//
//
//        if (e == 0) {
//            if (InputHandler.SPACE) {
//                b.x = x + 35;
//                b.y = y - 6;
//            }
//        }
//        if (e == 1) {
//            if (InputHandler.SPACE) {
//                b.x = x2 + 35;
//                b.y = y2 - 6;
//            }
//        }
//        if (e == 2) {
//            if (InputHandler.SPACE) {
//                b.x = x3 + 35;
//                b.y = y3 - 6;
//            }
//        }
//        if (e == 3) {
//            if (InputHandler.SPACE) {
//                b.x = x4 + 35;
//                b.y = y4 - 6;
//            }
//        }
//
//    }
//
//    public void wall() {
//        if (e == 0) {
//            if (x <= 0) {
//                x += 40;
//            }
//            if (x >= 1175) {
//                x -= 40;
//            }
//        }
//        if (e == 1) {
//            if (x2 <= 0) {
//                x2 += 40;
//            }
//            if (x2 >= 1175) {
//                x2 -= 40;
//            }
//        }
//        if (e == 2) {
//            if (x3 <= 0) {
//                x3 += 40;
//            }
//            if (x3 >= 1175) {
//                x3 -= 40;
//            }
//        }
//        if (e == 3) {
//            if (x4 <= 0) {
//                x4 += 40;
//            }
//            if (x4 >= 1175) {
//                x4 -= 40;
//            }
//        }
//    }
}
