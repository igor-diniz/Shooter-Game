import game.Bullet
import spock.lang.Specification

class BulletTest extends Specification
{
    def 'Bullet Creation'()
    {
        given:
        Bullet bullet = new Bullet(5)
        Bullet bullet1 = new Bullet(10)
        when:
        int range = bullet.getRange()
        bullet1.draw();
        then:
        bullet1.getRange() == 9
        range == 5
    }
}
