import fate.Enemy
import spock.lang.Specification
class EnemyTest extends Specification {
    def 'Enemy Creation'() {
        given:
        Enemy enemy = new Enemy(1);

        when:
        def health = enemy.getHealth()
        then:
        health == 1
    }
}
