import game.Bullet
import game.Player
import game.Position
import spock.lang.Specification

class BulletTest extends Specification
{
    def 'Bullet Creation'()
    {
        given:
        Player player = Stub()
        player.getPosition() >> new Position(10,10)
        Bullet bullet = new Bullet(player.getPosition(),5)
        Bullet bullet1 = new Bullet(player.getPosition(),10)
        when:
        int range = bullet.getRange()
        bullet1.draw();
        then:
        bullet1.getRange() == 9
        range == 5
    }
}
