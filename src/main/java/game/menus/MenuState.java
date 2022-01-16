package game.menus;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Game;

import java.util.ArrayList;
import java.util.List;

public class MenuState implements State
{
    private final List<String> messages;
    private int selected;
    private final Game game;
    MenuState(Game game)
    {
        this.game = game;
        messages = new ArrayList<String>();
        messages.add("EXIT");
        messages.add("INSTRUCTIONS");
        messages.add("PLAY");
        selected = 0;
    }

    @Override
    public void showMenu(TextGraphics graphics)
    {
        for(int i = 0; i < messages.size(); i++)
            graphics.putString(game.getScreen().getTerminalSize().getColumns()/5,game.getScreen().getTerminalSize().getRows()/(i+3),messages.get(i));
        graphics.putString(game.getScreen().getTerminalSize().getColumns()/5 - 2,game.getScreen().getTerminalSize().getRows()/(selected+3),"->");
    }

    @Override
    public void processInput(KeyStroke key) {

    }

    public void nextOption()
    {
        selected++;
        if(selected >= messages.size()) selected = 0;
    }

    public void previousOption()
    {
        selected--;
        if(selected == -1) selected = messages.size()-1;
    }

    public List<String> getMessages() {
        return messages;
    }

    public int getSelected() {
        return selected;
    }
}
