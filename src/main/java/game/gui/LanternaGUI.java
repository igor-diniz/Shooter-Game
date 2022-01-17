package game.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;

import java.io.IOException;

public class LanternaGUI implements GUI{
    @Override
    public void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position pos) {

    }

    @Override
    public void drawBackground(TextGraphics textGraphics, String color) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void clear() throws IOException {

    }

    @Override
    public void refresh() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void drawPlayer(Position position, String color) {

    }

    @Override
    public void drawMovingEntity(Position position, String color, char character, int damaged) {

    }

    @Override
    public void drawImmobileEntity(Position position, String color, char character) {

    }
}
