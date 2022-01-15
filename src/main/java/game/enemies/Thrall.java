package game.enemies;

import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Thrall extends Enemy {
    public Thrall(Position position) {
        super(position);
    }

    @Override
    protected int generateActionDelay() {return 3;}

    @Override
    protected char generateCharacter() {
        return 't';
    }

    @Override
    protected int generateHealth() {
        return 30;
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
