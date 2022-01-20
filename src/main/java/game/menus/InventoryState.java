package game.menus;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Game;
import game.gui.GUI;

public class InventoryState implements State
{
    private Game game;
    private int selected;
    public InventoryState(Game game)
    {
        this.game = game;
        selected = 0;
    }

    @Override
    public void show(GUI gui) {
        gui.drawInventory(game,selected);
    }

    @Override
    public void processInput(KeyStroke key) {
        if(key == null || key.getKeyType() != KeyType.Character) return;
        char choice = key.getCharacter();
        switch(choice)
        {
            case 'Q': case 'q':
                game.setState(new PlayState(game)); break;
            case 'W': case 'w':
            nextOption(); break;
            case 'S': case 's':
            previousOption(); break;
            case 'E': case 'e':
            game.getLevel().getPlayer().equipWeapon(game.getLevel().getPlayer().getInventory().get(selected)); break;
        }
    }
    public void nextOption()
    {
        selected--;
        if(selected == -1) selected = game.getLevel().getPlayer().getInventory().size()-1;
    }

    public void previousOption()
    {
        selected++;
        if(selected >= game.getLevel().getPlayer().getInventory().size()) selected = 0;
    }

    public int getSelected() {
        return selected;
    }
}
