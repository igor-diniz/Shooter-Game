package game.enemies;

import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Servitor extends Enemy {
    public Servitor(Position position) {
        super(position);
    }

    @Override
    protected int generateActionDelay() {
        return 2;
    }

    @Override
    protected char generateCharacter() {
        return 's';
    }

    @Override
    protected int generateHealth() {
        return 3;
    }

    @Override
    protected Weapon generateWeapon() {
        return new HandCannon();
    }

}
