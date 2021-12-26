import game.Enemy
import game.Position
import spock.lang.Specification
class EnemyTest extends Specification {
    def 'Enemy Creation'() {
        given:
        Enemy enemy = new Enemy(1,new Position(3,3));

        when:
        def health = enemy.getHealth()
        then:
        health == 1
    }

    def 'Moving Enemy'() {
        given:
        Enemy enemy1 = new Enemy(1,new Position(10,10));
        Enemy enemy2 = new Enemy(1,new Position(10,10));
        when:
        enemy1.moveUp()
        enemy1.moveRight()
        enemy2.moveLeft()
        enemy2.moveDown()
        then:
        enemy1.getPosition() == new Position(11,9)
        enemy2.getPosition() == new Position(9,11)
    }
}
