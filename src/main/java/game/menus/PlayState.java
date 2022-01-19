package game.menus;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Game;
import game.Level;
import game.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class PlayState implements State
{
    private final Game game;
    private final Level level;

    public PlayState(Game game)
    {
        this.game = game;
        this.level = game.getLevel();
    }

    public PlayState(Level level) throws IOException, URISyntaxException, FontFormatException {
        this.level = level;
        game = new Game();
    } //used for tests purposes

    @Override
    public void show(GUI gui) {
        level.step(gui);
        gui.drawGame(level);
    }

    @Override
    public void processInput(KeyStroke key) {
        if(key == null) return;
        if (key.getKeyType() == KeyType.EOF) {
            //gameOver = true;
            return;
        }
        if(key.getKeyType() != KeyType.Character) return;
        if(key.getCharacter() == 'i' || key.getCharacter() == 'I') game.setState(new InventoryState(game));
        level.processKey(key);
    }

    public Level getLevel() {return level;}
}
