package game.weapons

import game.weapons.SniperRifle
import spock.lang.Specification

class SniperRifleTest extends Specification {
    def 'Sniper Test'()
    {
        given:
        SniperRifle Sniper = new SniperRifle()
        SniperRifle Sniper1 = new SniperRifle()
        when:
        Sniper.shoot()
        Sniper1.shoot()
        Sniper1.shoot()
        then:
        Sniper.getAmmo() == 6
        Sniper1.getAmmo() == 5
    }
}
