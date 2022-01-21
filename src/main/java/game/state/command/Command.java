package game.state.command;

import game.Game;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Command
{
    protected Game game;
    public Command(Game game)
    {
        this.game = game;
    }

    public abstract String getText();

    public abstract void execute() throws IOException, URISyntaxException, FontFormatException;

    public abstract void undo();
}
