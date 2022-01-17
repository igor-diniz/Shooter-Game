package game.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;

import java.io.IOException;

public interface GUI
{
    void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position pos);

    void drawBackground(TextGraphics textGraphics, String color);

    int getWidth();

    int getHeight();

    void clear() throws IOException;

    void refresh() throws IOException;

    void close() throws IOException;

    void drawPlayer(Position position, String color);

    void drawMovingEntity(Position position, String color, char character, int damaged);

    void drawImmobileEntity(Position position, String color, char character);


}
