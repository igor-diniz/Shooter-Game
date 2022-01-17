package enemies

import game.Level
import game.Player
import game.Position
import game.Wall
import game.enemies.Acolyte
import game.enemies.Enemy
import game.weapons.EnemyWeapon2
import game.weapons.HandCannon
import game.weapons.Weapon
import spock.lang.Specification

class AcolyteTest extends Specification {

    private Level level
    private Player player

    void 'setup'()
    {
        level = new Level(20,20)
        player = new Player(new Position(1,1))
        level.generateEntities(player,new ArrayList<Enemy>(),new ArrayList<Wall>())
    }

    def 'Acolyte Creation'() {
        given:
        Acolyte enemy = new Acolyte(new Position(3,3));

        when:
        def health = enemy.getHealth()
        Weapon weapon = enemy.getWeapon();
        then:
        weapon instanceof EnemyWeapon2;
        health == 60
    }

    def 'Moving Acolyte'() {
        given:
        Acolyte enemy1 = new Acolyte(new Position(10,10));
        Acolyte enemy2 = new Acolyte(new Position(10,10));
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
        Acolyte Acolyte = new Acolyte(new Position(10,10))
        Acolyte Acolyte1 = new Acolyte(new Position(10,10))
        when:
        Acolyte.takeDamage(50,true)
        Acolyte1.takeDamage(60,true)
        then:
        Acolyte.getHealth() == 10
        Acolyte1.getHealth() == 0

    }

    def 'Delay Test'()
    {
        given:
        Acolyte enemy = new Acolyte(new Position(10,10));
        Acolyte enemy1 = new Acolyte(new Position(10,10));
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
