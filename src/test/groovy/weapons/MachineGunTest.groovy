package weapons

import game.weapons.MachineGun

class MachineGunTest {
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
        MachineGun.getAmmo() == 14
        MachineGun1.getAmmo() == 13
    }
}
