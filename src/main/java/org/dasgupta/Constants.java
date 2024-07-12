package org.dasgupta;

import java.awt.*;

public final class Constants {
    public static final int DEFAULT_SCREEN_WIDTH = 500;
    public static final int DEFAULT_SCREEN_HEIGHT = 500;
    public static final int SNAKE_PART_SIZE = 25;
    public static final int GAME_LOOP_INTERVAL = 200;
    private static final Color BACKGROUND_COLOR = new Color(130, 193, 145);
    public static final int APPLE_SIZE = 25;

    private Constants() {
    }

    public static Color getBackgroundColor() {
        return BACKGROUND_COLOR;
    }
}
