import spock.lang.Specification
class PlayerTest extends Specification
{
    def 'Player Creation'() {
        given:
        Player player = new Player(new Position(10,10));

        when:
        def weaponQuantity = player.getWeapons().size()
        def health = player.getHealth()
        then:
        weaponQuantity == 0
        health == 1
        player.getPosition() == new Position(10,10)
    }
    def 'Move Player'()
    {
        given:
        Player player1 = new Player(new Position(10,10));
        Player player2 = new Player(new Position(10,10));
        when:
        player1.moveUp()
        player1.moveLeft()
        player2.moveRight()
        player2.moveDown()
        then:
        player1.getPosition() == new Position(9,9)
        player2.getPosition() == new Position(11,11)
    }

}

