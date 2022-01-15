package enemies

import game.Position
import game.enemies.Thrall
import game.weapons.EnemyWeapon1
import game.weapons.HandCannon
import game.weapons.Weapon
import spock.lang.Specification

class ThrallTest extends Specification{
        def 'Thrall Creation'() {
            given:
            Thrall enemy = new Thrall(new Position(3,3));

            when:
            def health = enemy.getHealth()
            Weapon weapon = enemy.getWeapon();
            then:
            weapon instanceof EnemyWeapon1;
            health == 30
        }

        def 'Moving Thrall'() {
            given:
            Thrall enemy1 = new Thrall(new Position(10,10));
            Thrall enemy2 = new Thrall(new Position(10,10));
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
            Thrall Thrall = new Thrall(new Position(10,10))
            Thrall Thrall1 = new Thrall(new Position(10,10))
            when:
            Thrall.takeDamage(10)
            Thrall1.takeDamage(20)
            then:
            Thrall.getHealth() == 20
            Thrall1.getHealth() == 10

        }

        def 'Delay Test'()
        {
            given:
            Thrall enemy = new Thrall(new Position(10,10));
            Thrall enemy1 = new Thrall(new Position(10,10));
            when:
            enemy1.setPosition(enemy1.moveUp())
            enemy1.setPosition(enemy1.moveUp())
            enemy.setPosition(enemy1.moveUp())
            enemy.setPosition(enemy1.moveUp())
            enemy.setPosition(enemy1.moveUp())
            enemy.setPosition(enemy1.moveUp())
            then:
            enemy1.getPosition() == new Position(10,9)
            enemy1.getRemainingTime() == 2
            enemy.getPosition() == new Position(10,8)
        }
}
