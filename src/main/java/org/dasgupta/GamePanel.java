package org.dasgupta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class GamePanel extends JPanel implements ActionListener {
    private final int width;
    private final int height;
    private final Apple apple;
    private final Snake snake;

    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setBackground(Constants.getBackgroundColor());
        this.apple = new Apple(this);
        this.snake = new Snake();

        Timer timer = new Timer(Constants.GAME_LOOP_INTERVAL, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP -> snake.setDirection(Direction.UP);
                    case KeyEvent.VK_DOWN -> snake.setDirection(Direction.DOWN);
                    case KeyEvent.VK_LEFT -> snake.setDirection(Direction.LEFT);
                    case KeyEvent.VK_RIGHT -> snake.setDirection(Direction.RIGHT);
                }
            }
        });
        setFocusable(true);
        requestFocusInWindow();
    }

    public GamePanel() {
        this(Constants.DEFAULT_SCREEN_WIDTH, Constants.DEFAULT_SCREEN_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        apple.draw(graphics);
        snake.draw(graphics);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}