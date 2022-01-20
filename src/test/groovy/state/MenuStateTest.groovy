package state

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.gui.GUI
import game.menus.MenuState
import spock.lang.Specification

class MenuStateTest extends Specification
{
    private Game game;

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

    /*def 'Menu Process Input'()
    {
        given:
        MenuState mainMenu = new MenuState(game)
        KeyStroke key = Mock(KeyStroke.class)
        key.getKeyType() >> KeyType.Backspace >> KeyType.Character >> KeyType.Character
        key.getCharacter() >> 'w' >> 's' >> 'e'
        when:
        mainMenu.processInput(key)
        mainMenu.processInput(key)
        mainMenu.processInput(key)
        then:
        3 * key.getKeyType()
        2 * key.getCharacter()
    }*/
}
