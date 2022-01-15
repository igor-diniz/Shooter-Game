package enemies

import game.Position
import game.enemies.Knight
import game.weapons.HandCannon
import game.weapons.Weapon

class KnightTest {
    def 'Knight Creation'() {
        given:
        Knight enemy = new Knight(new Position(3,3));

        when:
        def health = enemy.getHealth()
        Weapon weapon = enemy.getWeapon();
        then:
        weapon instanceof HandCannon;
        health == 60
    }

    def 'Moving Knight'() {
        given:
        Knight enemy1 = new Knight(new Position(10,10));
        Knight enemy2 = new Knight(new Position(10,10));
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
        Knight Knight = new Knight(new Position(10,10))
        Knight Knight1 = new Knight(new Position(10,10))
        when:
        Knight.takeDamage(50)
        Knight1.takeDamage(60)
        then:
        Knight.getHealth() == 10
        Knight1.getHealth() == 0

    }

    def 'Delay Test'()
    {
        given:
        Knight enemy = new Knight(new Position(10,10));
        Knight enemy1 = new Knight(new Position(10,10));
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
