package game.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import game.Game;
import game.Level;
import game.Position;
import game.menus.Command;

import java.io.IOException;
import java.util.List;

public class LanternaGUI implements GUI {

    private TerminalScreen screen;
    private int width;
    private int height;

    public LanternaGUI(int width, int height) {
    }

    public LanternaGUI(TerminalScreen screen) {
        this.screen = screen;
        this.width = 10;
        this.height = 10;
    } //used for testing purposes

    @Override
    public void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position pos) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(pos.getX(), pos.getY()), new TerminalSize(width, height), ' ');
    }

    @Override
    public void fillBackground(TextGraphics textGraphics, String color) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void drawImmobileEntity(Position position, String color, char character) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(new TerminalPosition(position.getX(), position.getY()), String.valueOf(character));
    }

    @Override
    public void drawMovingEntity(Position position, String color, char character, int damaged) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        if (damaged > 0) tg.setForegroundColor(TextColor.Factory.fromString("#ff0000")); // Red for damage color
        tg.putString(new TerminalPosition(position.getX(), position.getY()), String.valueOf(character));
        damaged--;
    }
}