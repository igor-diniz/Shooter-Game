import game.Level
import spock.lang.Specification

class LevelTest extends Specification
{
    def 'Level Creation'()
    {
        given:
        Level level = new Level(10,10)
        when:
        int row = level.getNumRows()
        int columns = level.getNumColumns()
        char character = level.getCharacterAt(3,3)
        then:
        row == 10
        columns == 10
        character == 'x'
    }
}
