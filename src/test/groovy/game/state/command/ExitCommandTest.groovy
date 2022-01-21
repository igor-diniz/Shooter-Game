package game.state.command

import game.Game
import spock.lang.Specification

class ExitCommandTest extends Specification{
    def 'Exit Command Creation Test'()
    {
        Game game = Mock(Game.class)
        when:
        ExitCommand exitCommand = new ExitCommand(game)
        then:
        exitCommand.getText() == "EXIT"
    }
}
