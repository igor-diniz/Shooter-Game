package enemies

import game.Level
import game.entities.Player
import game.entities.Position
import game.entities.Wall
import game.enemies.Enemy
import game.enemies.Vandal
import game.weapons.EnemyWeapon2
import game.weapons.Weapon
import spock.lang.Specification

class VandalTest extends Specification {

    private Level level
    private Player player

    void 'setup'()
    {
        level = new Level(20,20)
        player = new Player(new Position(1,1))
        level.generateEntities(player,new ArrayList<Enemy>(),new ArrayList<Wall>())
    }

    def 'Vandal Creation'() {
        given:
        Vandal enemy = new Vandal(new Position(3,3));

        when:
        def health = enemy.getHealth()
        Weapon weapon = enemy.getWeapon();
        then:
        weapon instanceof EnemyWeapon2;
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
        enemy1.getPosition() == new Position(11,9)
        enemy2.getPosition() == new Position(9,11)
    }

    def 'Get Damaged'()
    {
        given:
        Vandal Vandal = new Vandal(new Position(10,10))
        Vandal Vandal1 = new Vandal(new Position(10,10))
        when:
        Vandal.takeDamage(10,true)
        Vandal1.takeDamage(20,true)
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
        enemy1.move(level,player)
        enemy1.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        then:
        enemy1.getRemainingTime() == 24
        enemy.getRemainingTime() == 21
    }
}
