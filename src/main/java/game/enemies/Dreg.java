package game.enemies;

import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Dreg extends Enemy {

    public Dreg(Position position) {
        super(position);
    }

    @Override
    protected int generateActionDelay() { return 3; }

    @Override
    protected char generateCharacter() {
        return 'd';
    }

    @Override
    protected int generateHealth() {
        return 1;
    }

    @Override
    protected Weapon generateWeapon() {
        return new HandCannon();
    }
}
