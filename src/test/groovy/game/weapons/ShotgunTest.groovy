package game.weapons

import game.weapons.Shotgun
import spock.lang.Specification

class ShotgunTest extends Specification
{
    def 'Shotgun Test'()
    {
        given:
        Shotgun shotgun = new Shotgun()
        Shotgun shotgun1 = new Shotgun()
        when:
        char bulletChar = shotgun.getBulletChar()
        char type  = shotgun.getType()
        String name = shotgun.getName()
        int damage = shotgun.getDamage()
        int range = shotgun.getRange()
        shotgun.shoot()
        shotgun1.shoot()
        shotgun1.shoot()
        then:
        shotgun.getAmmo() == 7
        shotgun1.getAmmo() == 6
        bulletChar == 'i' as char
        type == 'S' as char
        name == "SHOTGUN"
        damage == 80
        range == 2
    }
}
