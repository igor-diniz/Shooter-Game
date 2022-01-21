package game.state;

import com.googlecode.lanterna.input.KeyStroke;
import game.Game;
import game.gui.GUI;
import game.state.command.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GameOverState implements State{

    private Game game;
    private final Command command = new ExitCommand(game);

    public GameOverState(Game game)
    {
        this.game = game;
    }

    @Override
    public void show(GUI gui) {
        gui.drawGameOver();
    }

    @Override
    public void processInput(KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        char choice = key.getCharacter();
        switch(choice)
        {
            case 'E': case 'e':
            command.execute(); break;
        }
    }
}
