package game.weapons

import game.weapons.MachineGun
import spock.lang.Specification

class MachineGunTest extends Specification{
    def 'MachineGun Creation Test'()
    {
        given:
        MachineGun machineGun = new MachineGun()
        MachineGun machineGun1 = new MachineGun()
        when:
        char bulletChar = machineGun.getBulletChar()
        char type  = machineGun.getType()
        String name = machineGun.getName()
        int damage = machineGun.getDamage()
        int range = machineGun.getRange()
        machineGun.shoot()
        machineGun1.shoot()
        machineGun1.shoot()
        then:
        machineGun.getAmmo() == 24
        machineGun1.getAmmo() == 23
        bulletChar == 'l' as char
        type == 'H' as char
        name == "MACHINE GUN"
        damage == 70
        range == 5
    }
}
