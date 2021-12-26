import spock.lang.Specification
class EnemyTest {
    def 'Enemy Creation'() {
        given:
        Enemy enemy = new Enemy(1);

        when:
        def health = player.getHealth()
        then:
        health == 1
    }
}
