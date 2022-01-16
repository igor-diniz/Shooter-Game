package game.menus;

import game.Game;

public interface Command
{
    void execute(Game game);

    void undo(Game game);
}
