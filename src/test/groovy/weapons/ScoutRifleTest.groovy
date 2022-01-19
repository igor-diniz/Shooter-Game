package weapons

import game.weapons.ScoutRifle
import game.weapons.Shotgun
import spock.lang.Specification

class ScoutRifleTest extends Specification
{
    def 'ScoutRifle Test'()
    {
        given:
        ScoutRifle scoutRifle = new ScoutRifle()
        ScoutRifle scoutRifle1 = new ScoutRifle()
        when:
        scoutRifle.shoot()
        scoutRifle1.shoot()
        scoutRifle1.shoot()
        then:
        scoutRifle.getAmmo() == -1
        scoutRifle1.getAmmo() == -1
    }
}
