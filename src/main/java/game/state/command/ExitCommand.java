package game.state.command;

import game.Game;

public class ExitCommand extends Command {
    public ExitCommand(Game game) {
        super(game);
    }

    @Override
    public String getText() {
        return "EXIT";
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void undo() {

    }
}
