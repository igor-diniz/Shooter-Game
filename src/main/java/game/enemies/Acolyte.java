package game.enemies;

import game.Position;
import game.weapons.EnemyWeapon2;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Acolyte extends Enemy {
    public Acolyte(Position position) {
        super(position);
    }

    @Override
    protected int generateActionDelay() {return 6;}

    @Override
    protected char generateCharacter() {
        return 'a';
    }

    @Override
    protected int generateHealth() {
        return 60;
    }

    @Override
    protected Weapon generateWeapon() {
        return new EnemyWeapon2();
    }

    @Override
    protected String generateColor() {
        return "#f27935";
    }
}
