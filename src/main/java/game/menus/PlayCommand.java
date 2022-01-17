package game.menus;

import game.Game;

public class PlayCommand extends Command
{

    private State oldState;

    public PlayCommand(Game game) {
        super(game);
    }

    @Override
    String getText() {
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
