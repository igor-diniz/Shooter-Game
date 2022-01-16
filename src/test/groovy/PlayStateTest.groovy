

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.Level
import game.menus.PlayState
import spock.lang.Specification

class PlayStateTest extends Specification
{
    private Game game
    private KeyStroke key1
    void 'setup'()
    {
        game = new Game()
        game.setState(new PlayState(game.getLevel()))
        key1 = Stub(KeyStroke.class)
        key1.getKeyType() >> KeyType.Character >> KeyType.Character
        key1.getCharacter() >> 'w' >> 's'
    }

    def 'PlayStateCreation Test'()
    {
        when:
        PlayState playState = new PlayState(game.getLevel())
        then:
        playState.getLevel() == game.getLevel()
    }

    def 'PlayState Execution Test'()
    {
        given:
        Level level = Mock(Level.class)
        PlayState playState = new PlayState(level)
        when:
        playState.processInput(key1)
        playState.show(game.getScreen().newTextGraphics())
        then:
        1 * level.moveEnemies()
        1 * level.processKey(key1)
        1 * level.moveBullets()
        1 * level.draw(_)
        1 * level.checkCollisions()

    }
}
