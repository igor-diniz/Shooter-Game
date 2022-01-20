package game.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import game.*;
import game.entities.Bullet;
import game.entities.ImmobileEntity;
import game.entities.MovingEntity;
import game.entities.Position;
import game.menus.command.Command;

import java.io.IOException;
import java.util.List;

public interface GUI
{
    void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position pos);

    void fillBackground(TextGraphics textGraphics, String color);

    int getWidth();

    int getHeight();

    KeyStroke pollInput() throws IOException;

    void clear() throws IOException;

    void refresh() throws IOException;

    void close() throws IOException;

    void drawMovingEntity(MovingEntity movingEntity);

    void drawBullet(Bullet bullet);

    void drawImmobileEntity(ImmobileEntity immobileEntity);

    void drawMenu(Game game,int selected,List<Command> commandsList);

    void drawInventory(Game game,int selected);

    void drawInstructions(Game game);

    void drawGame(Level level);
}
