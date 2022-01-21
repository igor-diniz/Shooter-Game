package game.weapons

import game.weapons.RocketLauncher
import spock.lang.Specification

class RocketLauncherTest extends Specification{
    def 'RocketLauncher Test'()
    {
        given:
        RocketLauncher RocketLauncher = new RocketLauncher()
        RocketLauncher RocketLauncher1 = new RocketLauncher()
        when:
        RocketLauncher1.shoot()
        then:
        RocketLauncher.getAmmo() == 3
        RocketLauncher1.getAmmo() == 2
    }
}
