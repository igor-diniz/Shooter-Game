package game.enemies

import game.Level
import game.entities.Player
import game.entities.Wall
import game.enemies.Dreg
import game.entities.Position
import game.enemies.Enemy
import game.weapons.EnemyWeapon1
import game.weapons.Weapon
import spock.lang.Specification
class DregTest extends Specification {

    private Level level
    private Player player

    void 'setup'()
    {
        level = new Level(20,20)
        player = new Player(new Position(1,1))
        level.generateEntities(player,new ArrayList<Enemy>(),new ArrayList<Wall>())
    }

    def 'Dreg Creation'() {
        when:
        Dreg enemy = new Dreg(new Position(3,3));
        Weapon weapon = enemy.getWeapon();

        then:
        enemy.getHealth() == 40
        enemy.getCharacter() == 'd' as char
        enemy.getColor() == "#1064ad"
        weapon.getName() == "ENEMY WEAPON 1"
        weapon.getBulletChar() == 'b'as char
        weapon.getDamage() == 10
        weapon.getRange() == 5
    }

    def 'Moving Dreg'() {
        given:
        Dreg enemy1 = new Dreg(new Position(10,10));
        Dreg enemy2 = new Dreg(new Position(10,10));
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
        Dreg dreg = new Dreg(new Position(10,10))
        Dreg dreg1 = new Dreg(new Position(10,10))
        when:
        dreg.takeDamage(10,true)
        dreg1.takeDamage(20,true)
        then:
        dreg.getHealth() == 30
        dreg1.getHealth() == 20

    }

    def 'Delay Test'()
    {
        given:
        Dreg enemy = new Dreg(new Position(10,10));
        Dreg enemy1 = new Dreg(new Position(10,10));
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
        enemy.getWeapon().getAmmo() == -1
    }
}
