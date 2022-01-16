package enemies

import game.Level
import game.Player
import game.Wall
import game.enemies.Captain
import game.enemies.Dreg
import game.Position
import game.enemies.Enemy
import game.enemies.Vandal
import game.weapons.HandCannon
import game.weapons.Weapon
import spock.lang.Specification
class EnemyTest extends Specification {

    private Level level
    private Player player

    void 'setup'()
    {
        level = new Level(20,20)
        player = new Player(new Position(1,1))
        level.generateEntities(player,new ArrayList<Enemy>(),new ArrayList<Wall>())
    }

    def 'Enemy Creation'() {
        given:
        Dreg dreg = new Dreg(new Position(3,3))
        when:
        def health = dreg.getHealth()
        Weapon weapon = dreg.getWeapon();
        then:
        weapon instanceof HandCannon;
        health == 1
    }

    def 'Moving Enemy'() {
        given:
        Dreg enemy1 = new Dreg(new Position(10,10));
        Vandal enemy2 = new Vandal(new Position(5,5));
        Captain enemy3 = new Captain(new Position(7,7))
        when:
        enemy1.move(level,player)
        enemy2.move(level,player)
        enemy2.move(level,player)
        enemy3.move(level,player)
        then:
        level.getCharacterAt(10,10) != 'd'
        enemy2.getPosition() == new Position(5,4)
        enemy3.getPosition() == new Position(7,6)
    }

    def 'Get Damaged'()
    {
        given:
        Dreg dreg = new Dreg(new Position(10,10))
        Dreg dreg1 = new Dreg(new Position(10,10))
        when:
        dreg.takeDamage(1,true)
        dreg1.takeDamage(2,true)
        then:
        dreg.getHealth() == 0
        dreg1.getHealth() == 0

    }

    def 'Delay Test'()
    {
        given:
        Vandal enemy = new Vandal(new Position(10,10))
        Vandal enemy1 = new Vandal(new Position(10,10))
        when:
        enemy1.move(level,player)
        enemy1.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        enemy.move(level,player)
        then:
        enemy1.getPosition() == new Position(10,9)
        enemy1.getRemainingTime() == 2
        enemy.getPosition() == new Position(9,9)
    }
}
