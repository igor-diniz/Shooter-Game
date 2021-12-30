import game.Level
import game.Player
import game.Position
import game.enemies.Dreg
import game.enemies.Enemy
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

    def 'Level Entity Introduction'()
    {
        given:
        Level level = new Level(10,10)
        Player player = new Player(new Position(1,1))
        Dreg dreg = new Dreg(new Position(9,9))
        Dreg dreg2 = new Dreg(new Position(8,5))
        List<Enemy> enemyList = new ArrayList<Enemy>()
        enemyList.add(dreg)
        enemyList.add(dreg2)
        List<Wall> wallList = new ArrayList<Wall>()
        for(int i = 0; i < level.getNumRows();i++)
        {
            walllist.add(new Wall(new Position(0,i)))
            walllist.add(new Wall(new Position(level.getNumRows()-1,i)))
        }
        for(int i = 0; i < level.getNumColumns(); i++)
        {
            walllist.add(new Wall(new Position(i,0)))
            walllist.add(new Wall(new Position(i,level.getNumColumns()-1))
        }

        when:
        level.generateEntitys(player,enemyList,wallList)
        then:
        level.getCharacterAt(1,1) == 'H'
        level.getCharacterAt(8,5) == 'D'
        level.getCharacterAt(9,9) == 'D'
        level.getCharacterAt(0,5) == 'W'
    }
}
