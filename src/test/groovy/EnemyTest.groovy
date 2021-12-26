import game.enemies.Dreg
import game.Position
import spock.lang.Specification
class EnemyTest extends Specification {
    def 'Enemy Creation'() {
        given:
        Dreg enemy = new Dreg(1,new Position(3,3));

        when:
        def health = enemy.getHealth()
        then:
        health == 1
    }

    def 'Moving Enemy'() {
        given:
        Dreg enemy1 = new Dreg(1,new Position(10,10));
        Dreg enemy2 = new Dreg(1,new Position(10,10));
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
