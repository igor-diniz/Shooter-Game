package state


import game.Game
import game.gui.GUI
import game.gui.LanternaGUI
import game.state.InventoryState
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

    def 'Inventory Show Test'()
    {
        given:
        InventoryState inventoryState = new InventoryState(game)
        LanternaGUI gui = Mock(LanternaGUI.class)
        when:
        inventoryState.show(gui)
        then:
        1 * gui.drawInventory(game,_)
    }

}
