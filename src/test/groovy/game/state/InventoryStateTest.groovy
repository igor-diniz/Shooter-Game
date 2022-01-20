package game.state


import game.Game
import game.gui.GUI
import game.gui.LanternaGUI
import game.state.InventoryState
import spock.lang.Specification

class InventoryStateTest extends Specification
{
    private Game game = new Game()
    InventoryState inventoryState = new InventoryState(game)

    def 'Inventory Creation'()
    {
        when:
        int res = inventoryState.getSelected()
        then:
        res == 0
    }

    def 'Inventory option selection'()
    {
        when:
        inventoryState.previousOption()
        inventoryState.nextOption()
        inventoryState.nextOption()
        then:
        inventoryState.getSelected() == 3
    }

    def 'Inventory Show Test'()
    {
        LanternaGUI gui = Mock(LanternaGUI.class)
        when:
        inventoryState.show(gui)
        then:
        1 * gui.drawInventory(game,_)
    }

}
