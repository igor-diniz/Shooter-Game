package game.enemies;

import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Knight extends Enemy {
    public Knight(Position position) {
        super(position);
    }

    @Override
    protected int generateActionDelay() {return 9;}

    @Override
    protected char generateCharacter() {
        return 'k';
    }

    @Override
    protected int generateHealth() {
        return 100;
    }

    @Override
    protected Weapon generateWeapon() {
        return new HandCannon();
    }

    @Override
    protected String generateColor() {
        return "#f27935";
    }
}
