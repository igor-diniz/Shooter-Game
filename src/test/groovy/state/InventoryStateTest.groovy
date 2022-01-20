package state

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.gui.GUI
import game.menus.InventoryState
import game.menus.MenuState
import game.menus.PlayState
import spock.lang.Specification

class InventoryStateTest extends Specification
{
    private Game game;

    void 'setup'()
    {
        game = new Game();
    }

    def 'Inventory Creation'()
    {
        when:
        InventoryState inventoryState = new InventoryState(game)
        then:
        inventoryState.getSelected() == 0
    }

    def 'Inventory option selection'()
    {
        given:
        InventoryState inventoryState = new InventoryState(game)
        when:
        inventoryState.previousOption()
        inventoryState.nextOption()
        inventoryState.nextOption()
        then:
        inventoryState.getSelected() == 3
    }

    def 'Inventory Show'()
    {
        given:
        InventoryState inventoryState = new InventoryState(game)
        GUI gui = Mock(GUI.class)
        when:
        inventoryState.show(gui)
        then:
        1 * gui.drawInventory(game,_,_)
    }

}
