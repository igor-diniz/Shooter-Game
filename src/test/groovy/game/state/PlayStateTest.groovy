package game.state

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.Level
import game.entities.Player
import game.entities.Position
import game.gui.GUI
import game.gui.LanternaGUI
import game.state.PlayState
import spock.lang.Specification

import java.awt.Menu

class PlayStateTest extends Specification
{
    private Game game
    private KeyStroke key1
    private KeyStroke key2
    void 'setup'()
    {
        game = new Game()
        game.setState(new PlayState(game))
        key1 = Stub(KeyStroke.class)
        key1.getKeyType() >> KeyType.Character >> KeyType.Character
        key1.getCharacter() >> 'i'
        key2 = Stub(KeyStroke.class)
        key2.getKeyType() >> KeyType.Character >> KeyType.Character
        key2.getCharacter() >> 'q'
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
        level.getPlayer() >> new Player(new Position(10, 10))
        PlayState playState = new PlayState(level)
        LanternaGUI gui = Mock(LanternaGUI.class)
        when:
        playState.processInput(key1)
        playState.show(gui)
        then:
        1 * level.processKey(_)
        1 * gui.drawGame(_)
        1 * level.step(_);
    }

    def 'PlayState State Change Test'()
    {
        given:
        Game game2 = new Game()
        game2.setState(new PlayState(game2))
        PlayState playState = new PlayState(game)
        PlayState playState2 = new PlayState(game2)
        when:
        playState.processInput(key1)
        playState2.processInput(key2)
        then:
        game2.getState() instanceof MenuState
        game.getState() instanceof InventoryState
    }
}
