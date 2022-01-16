import game.Game
import game.menus.Main
import spock.lang.Specification

class MainMenuTest extends Specification
{
    private Game game;

    void 'setup'()
    {
        game = new Game();
    }

    def 'Menu Creation'()
    {
        when:
        Main mainMenu = new Main(game)
        then:
        mainMenu.getMessages().size() == 3
        mainMenu.getSelected() == 0
    }

    def 'Menu option selection'()
    {
        given:
        Main mainMenu = new Main(game)
        when:
        mainMenu.previousOption()
        mainMenu.nextOption()
        mainMenu.nextOption()
        then:
        mainMenu.getSelected() == 1
    }
}
