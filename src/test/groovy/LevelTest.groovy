import com.googlecode.lanterna.input.KeyStroke
import game.Level
import game.Player
import game.Position
import game.Wall
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
        Dreg dreg = new Dreg(new Position(8,8))
        Dreg dreg2 = new Dreg(new Position(8,5))
        List<Enemy> enemyList = new ArrayList<Enemy>()
        enemyList.add(dreg)
        enemyList.add(dreg2)
        List<Wall> wallList = new ArrayList<Wall>()
        for(int i = 0; i < level.getNumRows();i++)
        {
            wallList.add(new Wall(new Position(level.getNumRows()-1,i)))
            wallList.add (new Wall(new Position(0, i)))
        }
        for(int i = 0; i < level.getNumColumns(); i++)
        {
            wallList.add(new Wall(new Position(i,0)))
            wallList.add(new Wall(new Position(i,level.getNumColumns()-1)))
        }

        when:
        level.generateEntities(player,enemyList,wallList)
        then:
        level.getCharacterAt(1,1) == 'p'
        level.getCharacterAt(8,5) == 'd'
        level.getCharacterAt(8,8) == 'd'
        level.getCharacterAt(0,5) == 'w'
    }

    def 'Level player movement'()
    {
        given:
        Level level1 = new Level(10,10)
        Player player = new Player(new Position(6,7))
        Dreg dreg = new Dreg(new Position(5,6))
        Dreg dreg2 = new Dreg(new Position(8,5))
        List<Enemy> enemyList = new ArrayList<Enemy>()
        enemyList.add(dreg)
        enemyList.add(dreg2)
        List<Wall> wallList = new ArrayList<Wall>()
        for(int i = 0; i < level1.getNumRows();i++)
        {
            wallList.add(new Wall(new Position(level1.getNumRows()-1,i)))
            wallList.add (new Wall(new Position(0, i)))
        }
        for(int i = 0; i < level1.getNumColumns(); i++)
        {
            wallList.add(new Wall(new Position(i,0)))
            wallList.add(new Wall(new Position(i,level1.getNumColumns()-1)))
        }
        KeyStroke key1 = Stub()
        KeyStroke key2 = Stub()
        key1.getKeyType().toString() >> "ArrowUp" >> "ArrowLeft"
        key2.getKeyType().toString() >> "ArrowDown" >> "ArrowRight"
        Level level2 = new Level(level1)
        when:
        level1.processKey(key1)
        level1.processKey(key1) //this should fail because position 7,6 is not 'x'
        level2.processKey(key2)
        level2.processKey(key2)
        then:
        level1.getCharacterAt(6,6) == (char)'p'
        level2.getCharacterAt(7,8) == (char)'p'


    }
}
