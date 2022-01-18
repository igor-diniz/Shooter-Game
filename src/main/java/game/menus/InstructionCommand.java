package game.menus;

import game.Game;

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
