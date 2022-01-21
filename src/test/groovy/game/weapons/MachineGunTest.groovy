package game.weapons

import game.weapons.MachineGun
import spock.lang.Specification

class MachineGunTest extends Specification{
    def 'MachineGun Test'()
    {
        given:
        MachineGun MachineGun = new MachineGun()
        MachineGun MachineGun1 = new MachineGun()
        when:
        MachineGun.shoot()
        MachineGun1.shoot()
        MachineGun1.shoot()
        then:
        MachineGun.getAmmo() == 24
        MachineGun1.getAmmo() == 23
    }
}
