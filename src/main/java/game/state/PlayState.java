package game.state;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Game;
import game.Level;
import game.gui.GUI;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class PlayState implements State
{
    private final Game game;
    private Level level;

    public PlayState(Game game)
    {
        this.game = game;
        this.level = game.getLevel();
    }

    public PlayState(Level level) throws FileNotFoundException {
        this.level = level;
        game = new Game();
    } //used for tests purposes

    @Override
    public void show(GUI gui) throws FileNotFoundException {
        level.step(gui);
        if(level.getPlayer().getHealth() == 0) game.setState(new GameOverState(game));
        if(level.isNextLevel()) {
            game.loadLevelFromFile();
            this.level = game.getLevel();
        }
        gui.drawGame(level);
    }

    @Override
    public void processInput(KeyStroke key) {
        if(key.getCharacter() == 'i' || key.getCharacter() == 'I') game.setState(new InventoryState(game));
        if(key.getCharacter() == 'q' || key.getCharacter() == 'Q') game.setState(new MenuState(game));
        level.processKey(key);
    }

    public Level getLevel() {return level;}
}
