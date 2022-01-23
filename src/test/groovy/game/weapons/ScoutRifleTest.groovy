package game.weapons

import game.weapons.ScoutRifle
import game.weapons.Shotgun
import spock.lang.Specification

class ScoutRifleTest extends Specification
{
    def 'ScoutRifle Creation Test'()
    {
        given:
        ScoutRifle scoutRifle = new ScoutRifle()
        ScoutRifle scoutRifle1 = new ScoutRifle()
        when:
        char bulletChar = scoutRifle.getBulletChar()
        char type  = scoutRifle.getType()
        String name = scoutRifle.getName()
        int damage = scoutRifle.getDamage()
        int range = scoutRifle.getRange()
        scoutRifle.shoot()
        scoutRifle1.shoot()
        scoutRifle1.shoot()
        then:
        scoutRifle.getAmmo() == -1
        scoutRifle1.getAmmo() == -1
        bulletChar == 'b' as char
        type == 'P' as char
        name == "SCOUT RIFLE"
        damage == 30
        range == 10
    }
}
