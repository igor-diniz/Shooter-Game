package game.menus;

import game.Game;

public class ExitCommand extends Command {
    public ExitCommand(Game game) {
        super(game);
    }

    @Override
    String getText() {

    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void undo() {

    }
}
