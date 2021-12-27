import game.weapons.Shotgun
import spock.lang.Specification

class WeaponTest extends Specification
{
    def 'Shotgun Test'()
    {
        given:
        Shotgun shotgun = new Shotgun(3,2,10)
        Shotgun shotgun1 = new Shotgun(3,2,0)
        when:
        shotgun.shoot()
        shotgun1.shoot()
        then:
        shotgun.getAmmo() == 9
        shotgun1.getAmmo() == 0
    }
}
