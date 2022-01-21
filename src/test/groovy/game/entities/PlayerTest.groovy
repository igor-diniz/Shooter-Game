package game.entities

import game.entities.Bullet
import game.entities.Player
import game.entities.Position
import game.weapons.HandCannon
import game.weapons.RocketLauncher
import game.weapons.Shotgun
import spock.lang.Specification

class PlayerTest extends Specification
{
    Player player = new Player(new Position(10,10))
    Player player1 = new Player(new Position(10,10))
    Player player2 = new Player(new Position(10,10))
    def 'Player Creation'() {

        when:
        def health = player.getHealth()
        def color = player.getColor()
        then:
        color == "#000000"
        health == 150
        player.getPosition() == new Position(10,10)
    }
    def 'Move Player'()
    {
        when:
        player1.setPosition(player1.moveUp())
        player1.setPosition(player1.moveLeft())
        player2.setPosition(player2.moveRight())
        player2.setPosition(player2.moveDown())
        then:
        player1.getPosition() == new Position(9,9)
        player2.getPosition() == new Position(11,11)
    }

    def 'Player Shoot'()
    {
        player.setPrimaryWeapon(new Shotgun())
        int ammo = player.getUsingWeapon().getAmmo()
        player1.setWeaponInUse(2)
        when:
        player.getUsingWeapon().shoot()
        Bullet bullet = player1.shoot()
        then:
        bullet == null
        player.getUsingWeapon().getAmmo() == ammo -1
    }

    def 'Player damaged'()
    {
        when:
        player.takeDamage(1)
        player1.takeDamage(160)
        then:
        player.getHealth() == 149
        player1.getHealth() == 0
    }

    def 'Player Healing'()
    {
        player.takeDamage(5)
        when:
        player.heal()
        player1.heal()
        then:
        player
        player.getHealing() == 59
        player1.getHealing() == 1
    }

    def 'Player weapon changing test'()
    {
        given:
        player.equipWeapon(new HandCannon())
        player1.equipWeapon(new Shotgun())
        player2.equipWeapon(new RocketLauncher())
        Player player4 = new Player(new Position(10,10))
        when:
        player.setWeaponInUse(0)
        player1.setWeaponInUse(1)
        player2.setWeaponInUse(2)
        player4.setWeaponInUse(3)
        then:
        player.getUsingWeapon().getType() == 'P' as char
        player1.getUsingWeapon().getType() == 'S' as char
        player2.getUsingWeapon().getType() == 'H' as char
        player4.getUsingWeapon().getType() == ' ' as char
    }
}

