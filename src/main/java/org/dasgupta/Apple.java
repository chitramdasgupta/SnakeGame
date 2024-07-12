package org.dasgupta;

import java.awt.*;
import java.util.Random;

public final class Apple {
    private final GamePanel gamePanel;
    private final Random random;
    private final Rectangle sprite;

    public Apple(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.random = new Random();
        this.sprite = new Rectangle(0, 0, Constants.APPLE_SIZE, Constants.APPLE_SIZE);
        spawn();
    }

    public void spawn() {
        int newX = random.nextInt(0, gamePanel.getWidth() - sprite.width);
        int newY = random.nextInt(0, gamePanel.getHeight() - sprite.height);

        this.sprite.setLocation(newX, newY);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(sprite.x, sprite.y, sprite.width, sprite.height);
    }
}
