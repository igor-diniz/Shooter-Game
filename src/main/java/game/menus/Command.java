package game.menus;

import game.Game;

public abstract class Command
{
    protected Game game;
    public Command(Game game)
    {
        this.game = game;
    }

    public abstract String getText();

    public abstract void execute();

    public abstract void undo();
}
