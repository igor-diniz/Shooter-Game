package enemies

import game.Level
import game.Player
import game.Position
import game.Wall
import game.enemies.Captain
import game.enemies.Enemy
import game.weapons.EnemyWeapon3
import game.weapons.HandCannon
import game.weapons.Weapon
import spock.lang.Specification

class CaptainTest extends Specification{

    private Level level
    private Player player

    void 'setup'()
    {
        level = new Level(20,20)
        player = new Player(new Position(1,1))
        level.generateEntities(player,new ArrayList<Enemy>(),new ArrayList<Wall>())
    }

    def 'Captain Creation'() {
        given:
        Captain enemy = new Captain(new Position(3,3));

        when:
        def health = enemy.getHealth()
        Weapon weapon = enemy.getWeapon();
        then:
        weapon instanceof EnemyWeapon3;
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
        enemy1.getPosition() == new Position(11,9)
        enemy2.getPosition() == new Position(9,11)
    }

    def 'Get Damaged'()
    {
        given:
        Captain Captain = new Captain(new Position(10,10))
        Captain Captain1 = new Captain(new Position(10,10))
        when:
        Captain.takeDamage(10,true)
        Captain1.takeDamage(20,true)
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
        enemy1.move(level,player)
        enemy1.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        then:
        enemy1.getRemainingTime() == 89
        enemy.getRemainingTime() == 86
    }
}
