package game.state

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.Level
import game.entities.Player
import game.entities.Position
import game.gui.LanternaGUI
import game.state.command.ExitCommand
import spock.lang.Specification

class GameOverStateTest extends Specification
{
    Game game = Mock(Game.class)
    GameOverState gameOverState = new GameOverState(game)
    def 'GameOver State Show Test'()
    {
        LanternaGUI gui = Mock(LanternaGUI.class)
        when:
        gameOverState.show(gui)
        then:
        1 * gui.drawGameOver()
    }

    def 'gameOverState Process Input Test'()
    {
        given:
        ExitCommand exitCommand = Mock(ExitCommand.class)
        GameOverState gameOverState = new GameOverState(exitCommand)
        KeyStroke key1 = Stub(KeyStroke.class)
        key1.getKeyType() >> KeyType.Character
        key1.getCharacter() >> 'a' >>'e'
        when:
        gameOverState.processInput(key1)
        gameOverState.processInput(key1)
        then:
        1 * exitCommand.execute()

    }
}
