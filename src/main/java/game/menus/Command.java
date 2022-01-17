package game.menus;

import game.Game;

public abstract class Command
{
    protected Game game;
    public Command(Game game)
    {
        this.game = game;
    }

    abstract String getText();

    abstract void execute();

    abstract void undo();
}
