package enemies

import game.Level
import game.entities.Player
import game.entities.Position
import game.entities.Wall
import game.enemies.Enemy
import game.enemies.Thrall
import game.weapons.EnemyWeapon1
import game.weapons.Weapon
import spock.lang.Specification

class ThrallTest extends Specification{

    private Level level
    private Player player

    void 'setup'()
    {
      level = new Level(20,20)
     player = new Player(new Position(1,1))
      level.generateEntities(player,new ArrayList<Enemy>(),new ArrayList<Wall>())
    }

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
        enemy1.getPosition() == new Position(11,9)
        enemy2.getPosition() == new Position(9,11)
    }

    def 'Get Damaged'()
    {
        given:
        Thrall Thrall = new Thrall(new Position(10,10))
        Thrall Thrall1 = new Thrall(new Position(10,10))
        when:
        Thrall.takeDamage(10,true)
        Thrall1.takeDamage(20,true)
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
        enemy1.move(level,player)
        enemy1.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        then:
        enemy1.getRemainingTime() == 14
        enemy.getRemainingTime() == 11
    }
}
