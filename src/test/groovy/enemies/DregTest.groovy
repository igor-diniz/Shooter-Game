package enemies

import game.Player
import game.enemies.Dreg
import game.Position
import game.weapons.HandCannon
import game.weapons.Weapon
import spock.lang.Specification
class DregTest extends Specification {
    def 'Dreg Creation'() {
        given:
        Dreg enemy = new Dreg(new Position(3,3));

        when:
        def health = enemy.getHealth()
        Weapon weapon = enemy.getWeapon();
        then:
        weapon instanceof HandCannon;
        health == 1
    }

    def 'Moving Dreg'() {
        given:
        Dreg enemy1 = new Dreg(new Position(10,10));
        Dreg enemy2 = new Dreg(new Position(10,10));
        when:
        enemy1.setPosition(enemy1.moveUp())
        enemy1.setPosition(enemy1.moveRight())
        enemy2.setPosition(enemy2.moveLeft())
        enemy2.setPosition(enemy2.moveDown())
        then:
        enemy1.getPosition() == new Position(11,9)
        enemy2.getPosition() == new Position(9,11)
    }

    def 'Get Damaged'()
    {
        given:
        Dreg dreg = new Dreg(new Position(10,10))
        Dreg dreg1 = new Dreg(new Position(10,10))
        when:
        dreg.getDamaged(1)
        dreg1.getDamaged(2)
        then:
        dreg.getHealth() == 0
        dreg1.getHealth() == 0

    }
}
