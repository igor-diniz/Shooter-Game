import spock.lang.Specification
class PlayerTest extends Specification
{
    def 'Player Creation'() {
        given:
        Player player = new Player(1);

        when:
        def weaponQuantity = player.getWeapons().size()
        def health = player.getHealth()
        then:
        weaponQuantity == 0
        health == 1
    }
}

