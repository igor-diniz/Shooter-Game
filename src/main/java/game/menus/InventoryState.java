package game.menus;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Game;
import game.Player;
import game.weapons.Weapon;

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
    public void show(TextGraphics graphics) {

        graphics.putString(1,1,"EQUIPPED WEAPONS");
        graphics.putString(1,2,game.getLevel().getPlayer().getPrimaryWeapon().getName());
        graphics.putString(1,3,game.getLevel().getPlayer().getSpecialWeapon().getName());
        graphics.putString(1,4,game.getLevel().getPlayer().getHeavyWeapon().getName());

        for(int i = 0; i < game.getLevel().getPlayer().getInventory().size(); i++)
            graphics.putString(graphics.getSize().getColumns()/3,
                    graphics.getSize().getRows()/4+i,game.getLevel().getPlayer().getInventory().get(i).getName());
        graphics.putString(game.getScreen().getTerminalSize().getColumns()/3 - 2,
                game.getScreen().getTerminalSize().getRows()/4+selected,"->");
        graphics.putString(game.getScreen().getTerminalSize().getColumns()-9,game.getScreen().getTerminalSize().getRows()-4,"UP : W");
        graphics.putString(game.getScreen().getTerminalSize().getColumns()-9,game.getScreen().getTerminalSize().getRows()-3,"DW : S");
        graphics.putString(game.getScreen().getTerminalSize().getColumns()-9,game.getScreen().getTerminalSize().getRows()-2,"GO : E");
        graphics.putString(game.getScreen().getTerminalSize().getColumns()-9,game.getScreen().getTerminalSize().getRows()-1,"BK : Q");


    }

    @Override
    public void processInput(KeyStroke key) {
        if(key == null) return;
        if (key.getKeyType() == KeyType.EOF) {
            return;
        }
        if(key.getKeyType() != KeyType.Character) return;
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
