

import game.Game
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
        mainMenu.getSelected() == 1
    }
}
