package enemies

import game.Position
import game.enemies.Captain
import game.weapons.HandCannon
import game.weapons.Weapon
import spock.lang.Specification

class CaptainTest extends Specification{
    def 'Captain Creation'() {
        given:
        Captain enemy = new Captain(new Position(3,3));

        when:
        def health = enemy.getHealth()
        Weapon weapon = enemy.getWeapon();
        then:
        weapon instanceof HandCannon;
        health == 100
    }

    def 'Moving Captain'() {
        given:
        Captain enemy1 = new Captain(new Position(10,10));
        Captain enemy2 = new Captain(new Position(10,10));
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
        Captain Captain = new Captain(new Position(10,10))
        Captain Captain1 = new Captain(new Position(10,10))
        when:
        Captain.takeDamage(10)
        Captain1.takeDamage(20)
        then:
        Captain.getHealth() == 90
        Captain1.getHealth() == 80

    }

    def 'Delay Test'()
    {
        given:
        Captain enemy = new Captain(new Position(10,10));
        Captain enemy1 = new Captain(new Position(10,10));
        when:
        enemy1.setPosition(enemy1.moveUp())
        enemy1.setPosition(enemy1.moveUp())
        enemy.setPosition(enemy1.moveUp())
        enemy.setPosition(enemy1.moveUp())
        enemy.setPosition(enemy1.moveUp())
        enemy.setPosition(enemy1.moveUp())
        then:
        enemy1.getPosition() == new Position(10,9)
        enemy1.getRemainingTime() == 8
        enemy.getPosition() == new Position(10,8)
    }
}
