package game.state

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.gui.GUI
import game.state.MenuState
import spock.lang.Specification

class MenuStateTest extends Specification
{
    private Game game

    void 'setup'()
    {
        game = new Game();
    }

    def 'Menu Creation'()
    {
        when:
        MenuState mainMenu = new MenuState(game)
        then:
        mainMenu.getSelected() == 0
    }

    def 'Menu option selection'()
    {
        given:
        MenuState mainMenu = new MenuState(game)
        when:
        mainMenu.previousOption()
        mainMenu.nextOption()
        mainMenu.nextOption()
        then:
        mainMenu.getSelected() == 2
    }

   def 'Menu Show'()
    {
        given:
        MenuState mainMenu = new MenuState(game)
        GUI gui = Mock(GUI.class)
        when:
        mainMenu.show(gui)
        then:
        1 * gui.drawMenu(game,_,_)
    }



    def 'Menu Process Input'() {
        given:
        MenuState mainMenu = Spy(constructorArgs: [game])
        KeyStroke key = Stub(KeyStroke)
        key.getKeyType() >> KeyType.Character
        key.getCharacter() >>> ['w', 'w', 'S', 's', 'E', 'e']
        when:
        mainMenu.processInput(key)
        mainMenu.processInput(key)
        mainMenu.processInput(key)
        mainMenu.processInput(key)
        mainMenu.processInput(key)
        mainMenu.processInput(key)
        then:
        2 * mainMenu.nextOption()
        2 * mainMenu.previousOption()
    }
}
