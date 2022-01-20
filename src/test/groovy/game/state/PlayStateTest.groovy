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
        try {
            given:
            Level level = Mock(Level.class)
            level.getPlayer() >> new Player(new Position(10, 10))
            PlayState playState = new PlayState(level)
            when:
            playState.processInput(key1)
            playState.show(new LanternaGUI(10, 10))
            then:
            1 * level.draw(_);
            1 * level.step(_);
        }catch(Exception e){System.out.println(e)}

    }
}
