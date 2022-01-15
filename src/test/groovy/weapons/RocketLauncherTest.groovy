package weapons

import game.weapons.RocketLauncher

class RocketLauncherTest {
    def 'RocketLauncher Test'()
    {
        given:
        RocketLauncher RocketLauncher = new RocketLauncher()
        RocketLauncher RocketLauncher1 = new RocketLauncher()
        when:
        RocketLauncher1.shoot()
        then:
        RocketLauncher.getAmmo() == 1
        RocketLauncher1.getAmmo() == 0
    }
}
