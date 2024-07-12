package org.dasgupta;

import java.awt.*;
import java.util.ArrayList;

public final class Snake {
    private static class SnakePart {
        private Point position;

        public SnakePart(Point position) {
            this.position = position;
        }

        public Point getPosition() {
            return position;
        }

        public void setPosition(Point position) {
            this.position = position;
        }
    }

    private final ArrayList<SnakePart> parts;
    private Direction direction;

    public Snake() {
        parts = new ArrayList<>();
        parts.add(new SnakePart(new Point(100, 100))); // TODO Middle of the screen
        this.direction = Direction.RIGHT;
    }

    public void move() {
        SnakePart head = parts.getFirst();
        Point newPosition = head.getPosition();
        switch (this.direction) {
            case UP -> newPosition.y -= Constants.SNAKE_PART_SIZE;
            case DOWN -> newPosition.y += Constants.SNAKE_PART_SIZE;
            case LEFT -> newPosition.x -= Constants.SNAKE_PART_SIZE;
            case RIGHT -> newPosition.x += Constants.SNAKE_PART_SIZE;
        }

        head.setPosition(newPosition);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        for (SnakePart part : parts) {
            Point pos = part.getPosition();
            g.fillRect(pos.x, pos.y, Constants.SNAKE_PART_SIZE, Constants.SNAKE_PART_SIZE);
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
