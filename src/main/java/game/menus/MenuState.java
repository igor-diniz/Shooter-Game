package game.menus;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Game;

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
        commandsList.add(new ExitCommand(game));
        commandsList.add(new InstructionCommand(game));
        commandsList.add(new PlayCommand(game));
        selected = 0;
    }

    @Override
    public void show(TextGraphics graphics)
    {
        for(int i = 0; i < commandsList.size(); i++)
            graphics.putString(game.getScreen().getTerminalSize().getColumns()/5,game.getScreen().getTerminalSize().getRows()/(i+3),commandsList.get(i).getText());
        graphics.putString(game.getScreen().getTerminalSize().getColumns()/5 - 2,game.getScreen().getTerminalSize().getRows()/(selected+3),"->");
    }

    @Override
    public void processInput(KeyStroke key) {
        if(key == null) return;
        if (key.getKeyType() == KeyType.EOF) {
            //gameOver = true;
            return;
        }
        if(key.getKeyType() != KeyType.Character) return;
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
        selected++;
        if(selected >= commandsList.size()) selected = 0;
    }

    public void previousOption()
    {
        selected--;
        if(selected == -1) selected = commandsList.size()-1;
    }

    public int getSelected() {
        return selected;
    }
}
