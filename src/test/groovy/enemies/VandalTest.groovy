package enemies

import game.Position
import game.enemies.Vandal
import game.weapons.HandCannon
import game.weapons.Weapon
import spock.lang.Specification

class VandalTest extends Specification {
    def 'Vandal Creation'() {
        given:
        Vandal enemy = new Vandal(new Position(3,3));

        when:
        def health = enemy.getHealth()
        Weapon weapon = enemy.getWeapon();
        then:
        weapon instanceof HandCannon;
        health == 60
    }

    def 'Moving Vandal'() {
        given:
        Vandal enemy1 = new Vandal(new Position(10,10));
        Vandal enemy2 = new Vandal(new Position(10,10));
        when:
        enemy1.setPosition(enemy1.moveUp())
        enemy1.setPosition(enemy1.moveRight())
        enemy2.setPosition(enemy2.moveLeft())
        enemy2.setPosition(enemy2.moveDown())
        then:
        enemy1.getPosition() == new Position(10,9)
        enemy2.getPosition() == new Position(9,10)
    }

    def 'Get Damaged'()
    {
        given:
        Vandal Vandal = new Vandal(new Position(10,10))
        Vandal Vandal1 = new Vandal(new Position(10,10))
        when:
        Vandal.takeDamage(10)
        Vandal1.takeDamage(20)
        then:
        Vandal.getHealth() == 50
        Vandal1.getHealth() == 40

    }

    def 'Delay Test'()
    {
        given:
        Vandal enemy = new Vandal(new Position(10,10));
        Vandal enemy1 = new Vandal(new Position(10,10));
        when:
        enemy1.setPosition(enemy1.moveUp())
        enemy1.setPosition(enemy1.moveUp())
        enemy.setPosition(enemy1.moveUp())
        enemy.setPosition(enemy1.moveUp())
        enemy.setPosition(enemy1.moveUp())
        enemy.setPosition(enemy1.moveUp())
        then:
        enemy1.getPosition() == new Position(10,9)
        enemy1.getRemainingTime() == 5
        enemy.getPosition() == new Position(10,8)
    }
}
