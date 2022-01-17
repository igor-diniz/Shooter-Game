package weapons

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
        shotgun.shoot()
        shotgun1.shoot()
        shotgun1.shoot()
        then:
        shotgun.getAmmo() == 4
        shotgun1.getAmmo() == 3
    }
}
