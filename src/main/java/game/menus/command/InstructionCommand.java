package game.menus.command;

import game.Game;
import game.menus.InstructionState;
import game.menus.State;

public class InstructionCommand extends Command{

    private State oldState;

    public InstructionCommand(Game game) {
        super(game);
    }

    @Override
    public String getText() {
        return "INSTRUCTIONS";
    }

    @Override
    public void execute() {
        oldState = game.getState();
        game.setState(new InstructionState());
    }

    @Override
    public void undo() {
        game.setState(oldState);
    }
}
