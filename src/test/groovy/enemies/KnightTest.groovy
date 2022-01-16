package enemies

import game.Level
import game.Player
import game.Position
import game.Wall
import game.enemies.Enemy
import game.enemies.Knight
import game.weapons.EnemyWeapon3
import game.weapons.HandCannon
import game.weapons.Weapon
import spock.lang.Specification

class KnightTest extends Specification {

    private Level level
    private Player player

    void 'setup'()
    {
        level = new Level(20,20)
        player = new Player(new Position(1,1))
        level.generateEntities(player,new ArrayList<Enemy>(),new ArrayList<Wall>())
    }

    def 'Knight Creation'() {
        given:
        Knight enemy = new Knight(new Position(3,3));

        when:
        def health = enemy.getHealth()
        Weapon weapon = enemy.getWeapon();
        then:
        weapon instanceof EnemyWeapon3;
        health == 100
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
        enemy1.getPosition() == new Position(11,9)
        enemy2.getPosition() == new Position(9,11)
    }

    def 'Get Damaged'()
    {
        given:
        Knight Knight = new Knight(new Position(10,10))
        Knight Knight1 = new Knight(new Position(10,10))
        when:
        Knight.takeDamage(90,true)
        Knight1.takeDamage(100,true)
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
        enemy1.move(level,player)
        enemy1.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        then:
        enemy1.getRemainingTime() == 34
        enemy.getRemainingTime() == 31
    }
}
