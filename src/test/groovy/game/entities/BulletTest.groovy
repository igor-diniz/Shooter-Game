package game.entities


import game.weapons.HandCannon
import game.weapons.Shotgun
import game.weapons.Weapon
import spock.lang.Specification

class BulletTest extends Specification
{
    def 'Bullet Creation'()
    {
        given:
        Player player = Stub()
        player.getPosition() >> new Position(10,10)
        Weapon weapon = new HandCannon()
        Weapon weapon2 = new Shotgun()
        Bullet bullet = new Bullet(player.getPosition(), weapon, 'N' as char, false, 'b' as char)
        Bullet bullet1 = new Bullet(player.getPosition(), weapon2, 'N' as char, false, 'l' as char)
        when:
        int range = bullet.getRange()
        bullet1.decreaseRange()
        char bulletChar = bullet.getCharacter()
        char bulletChar2 = bullet1.getCharacter()
        then:
        bulletChar == 'b' as char
        bulletChar2 == 'l' as char
        bullet1.getRange() == 1
        range == 7
    }
}
