import game.Game
import spock.lang.Specification

class GameTest extends Specification
{
    def 'Game Creation'()
    {
        given:
        Game game = new Game(10,10)
        when:
        int row = game.getNumRows()
        int columns = game.getNumColumns()
        char character = game.getCharacterAt(3,3)
        then:
        row == 10
        columns == 10
        character == 'x'
    }
}
