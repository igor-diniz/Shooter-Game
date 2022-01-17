package game.menus;

import game.Game;

public class ExitCommand extends Command {
    public ExitCommand(Game game) {
        super(game);
    }

    @Override
    String getText() {
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
