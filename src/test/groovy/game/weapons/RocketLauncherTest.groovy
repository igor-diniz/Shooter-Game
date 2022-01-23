package game.weapons

import game.weapons.RocketLauncher
import spock.lang.Specification

class RocketLauncherTest extends Specification{
    def 'RocketLauncher Creation Test'()
    {
        given:
        RocketLauncher RocketLauncher = new RocketLauncher()
        RocketLauncher RocketLauncher1 = new RocketLauncher()
        when:
        char bulletChar = RocketLauncher.getBulletChar()
        char type  = RocketLauncher.getType()
        String name = RocketLauncher.getName()
        int damage = RocketLauncher.getDamage()
        int range = RocketLauncher.getRange()
        RocketLauncher1.shoot()
        then:
        RocketLauncher.getAmmo() == 3
        RocketLauncher1.getAmmo() == 2
        bulletChar == 'o' as char
        type == 'H' as char
        name == "ROCKET LAUNCHER"
        damage == 150
        range == 10
    }
}
