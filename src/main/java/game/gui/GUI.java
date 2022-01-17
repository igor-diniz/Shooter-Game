package game.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Game;
import game.Level;
import game.Position;
import game.menus.Command;

import java.io.IOException;
import java.util.List;

public interface GUI
{
    void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position pos);

    void fillBackground(TextGraphics textGraphics, String color);

    int getWidth();

    int getHeight();

    void clear() throws IOException;

    void refresh() throws IOException;

    void close() throws IOException;

    void drawMovingEntity(Position position, String color, char character, int damaged);

    void drawImmobileEntity(Position position, String color, char character);

    void drawMenu(Game game,int selected,List<Command> commandsList);

    void drawInventory(Game game,int selected);

    void drawInstructions(Game game);

    void drawGame(Level level);
}
