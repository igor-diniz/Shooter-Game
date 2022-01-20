package game.state

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.Level
import game.enemies.Enemy
import game.entities.Player
import game.entities.Position
import game.entities.Wall
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

    def 'Inventory Process Key'()
    {
        given:
        InventoryState inventoryState1 = Spy(constructorArgs: [game])
        KeyStroke key = Stub(KeyStroke)
        key.getKeyType() >> KeyType.Character
        key.getCharacter() >>> ['w', 'w', 'S', 's', 'E', 'q']
        when:
        inventoryState1.processInput(key)
        inventoryState1.processInput(key)
        inventoryState1.processInput(key)
        inventoryState1.processInput(key)
        inventoryState1.processInput(key)
        inventoryState1.processInput(key)
        then:
        2 * inventoryState1.nextOption()
        2 * inventoryState1.previousOption()
    }

}
