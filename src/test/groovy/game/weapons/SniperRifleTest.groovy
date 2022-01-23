package game.weapons

import game.weapons.SniperRifle
import spock.lang.Specification

class SniperRifleTest extends Specification {
    def 'Sniper Test'()
    {
        given:
        SniperRifle sniper = new SniperRifle()
        SniperRifle sniper1 = new SniperRifle()
        when:
        char bulletChar = sniper.getBulletChar()
        char type  = sniper.getType()
        String name = sniper.getName()
        int damage = sniper.getDamage()
        int range = sniper.getRange()
        sniper.shoot()
        sniper1.shoot()
        sniper1.shoot()
        then:
        sniper.getAmmo() == 6
        sniper1.getAmmo() == 5
        bulletChar == 'b' as char
        type == 'S' as char
        name == "SNIPER RIFLE"
        damage == 80
        range == 10
    }
}
