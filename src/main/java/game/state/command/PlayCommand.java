package game.state.command;

import game.Game;
import game.state.PlayState;
import game.state.State;

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
