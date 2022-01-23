package game.enemies

import game.Level
import game.entities.Player
import game.entities.Wall
import game.enemies.Captain
import game.enemies.Dreg
import game.entities.Position
import game.enemies.Enemy
import game.enemies.Vandal
import game.enemies.strategy.TrackStrategy
import game.weapons.EnemyWeapon1
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
        weapon instanceof EnemyWeapon1;
        health == 40
    }

    def 'Moving Enemy'() {
        given:
        Player player2 = new Player(new Position(18,18))
        Acolyte acolyte = new Acolyte(new Position(15,15))
        Vandal vandal = new Vandal(new Position(7,8));
        Captain captain = new Captain(new Position(7,7))
        Thrall thrall = new Thrall(new Position(10,10))
        Level mockedLevel = Mock(Level.class)
        when:
        for(int i = 0; i < 90; i++) {
            vandal.move(level, player)
            captain.move(level, player)
            acolyte.move(level,player2)
            thrall.move(mockedLevel,player2) //his test is different cause his move is random
        }
        then:
        vandal.getPosition() == new Position(7,6)
        captain.getPosition() == new Position(6,5)
        acolyte.getPosition() == new Position(17,17)
        thrall.getRemainingTime() == 6
        6 * mockedLevel.isValidMove(_)
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
        dreg.getHealth() == 39
        dreg1.getHealth() == 38

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
        enemy1.getRemainingTime() == 24
        enemy.getRemainingTime() == 21
    }
}
