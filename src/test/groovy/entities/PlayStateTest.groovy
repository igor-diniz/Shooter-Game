package entities

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.Level
import game.entities.Player
import game.entities.Position
import game.gui.GUI
import game.state.PlayState
import spock.lang.Specification

class PlayStateTest extends Specification
{
    private Game game
    private KeyStroke key1
    void 'setup'()
    {
        game = new Game()
        game.setState(new PlayState(game))
        key1 = Stub(KeyStroke.class)
        key1.getKeyType() >> KeyType.Character >> KeyType.Character
        key1.getCharacter() >> 'w' >> 's'
    }

    def 'PlayStateCreation Test'()
    {
        when:
        PlayState playState = new PlayState(game)
        then:
        playState.getLevel() == game.getLevel()
    }

    def 'PlayState Execution Test'()
    {
        given:
        Level level = Mock(Level.class)
        level.getPlayer() >> new Player(new Position(10,10))
        PlayState playState = new PlayState(level)
        GUI gui = game.getGUI()
        when:
        playState.processInput(key1)
        playState.show(gui)
        then:
        1 * level.draw(gui);
        1 * level.step(gui);

    }
}
