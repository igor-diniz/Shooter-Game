package game.state;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Game;
import game.gui.GUI;
import game.state.command.Command;
import game.state.command.ExitCommand;
import game.state.command.InstructionCommand;
import game.state.command.PlayCommand;

import java.util.ArrayList;
import java.util.List;

public class MenuState implements State
{
    private final List<Command> commandsList;
    private int selected;
    private final Game game;
    public MenuState(Game game)
    {
        this.game = game;
        commandsList = new ArrayList<Command>();
        commandsList.add(new PlayCommand(game));
        commandsList.add(new InstructionCommand(game));
        commandsList.add(new ExitCommand(game));
        selected = 0;
    }

    @Override
    public void show(GUI gui)
    {
        gui.drawMenu(game,selected,commandsList);
    }

    @Override
    public void processInput(KeyStroke key) {
        if(key == null || key.getKeyType() != KeyType.Character) return;
        char choice = key.getCharacter();
        switch(choice)
        {
            case 'W': case 'w':
            nextOption(); break;
            case 'S': case 's':
            previousOption(); break;
            case 'E': case 'e':
            commandsList.get(selected).execute(); break;
        }
    }

    public void nextOption()
    {
        selected--;
        if(selected == -1) selected = commandsList.size()-1;
    }

    public void previousOption()
    {
        selected++;
        if(selected >= commandsList.size()) selected = 0;
    }

    public int getSelected() {
        return selected;
    }
}
