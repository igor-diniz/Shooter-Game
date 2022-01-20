package game.state;

import com.googlecode.lanterna.input.KeyStroke;
import game.Game;
import game.gui.GUI;

public class InstructionState implements State {

    private Game game;
    public InstructionState(Game game)
    {
        this.game = game;
    }

    @Override
    public void show(GUI gui) {
        gui.drawInstructions();
    }

    @Override
    public void processInput(KeyStroke keystroke) {
        if(keystroke.getCharacter() == 'q' || keystroke.getCharacter() == 'Q'){ game.setState(new MenuState(game));}
    }
}
