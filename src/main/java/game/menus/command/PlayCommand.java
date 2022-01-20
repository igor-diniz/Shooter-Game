package game.menus.command;

import game.Game;
import game.menus.PlayState;
import game.menus.State;

public class PlayCommand extends Command
{

    private State oldState;

    public PlayCommand(Game game) {
        super(game);
    }

    @Override
    public String getText() {
        return "PLAY";
    }

    @Override
    public void execute() {
        oldState = game.getState();
        game.setState(new PlayState(game));
    }

    @Override
    public void undo() {
        game.setState(oldState);
    }
}
