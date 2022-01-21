package game.state.command

import game.Game
import spock.lang.Specification

class PlayCommandTest extends Specification{
    def 'Play Command Creation Test'()
    {
        Game game = Mock(Game.class)
        when:
        PlayCommand playCommand = new PlayCommand(game)
        then:
        playCommand.getText() == "PLAY"
    }

    def 'Play Command Operations Test'()
    {
        given:
        Game game = Mock(Game.class)
        PlayCommand playCommand = new PlayCommand(game)
        when:
        playCommand.execute()
        playCommand.undo()
        then:
        2 * game.setState(_)
        1 * game.getState()
    }
}
