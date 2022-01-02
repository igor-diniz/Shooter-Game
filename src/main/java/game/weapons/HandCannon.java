package game.weapons;

import game.Player;

public class HandCannon extends Weapon{


    public HandCannon(){

    }

    @Override
    protected int generateDamage() {
        return 1;
    }

    @Override
    protected int generateRange() {
        return 3;
    }

    @Override
    protected int getStartAmmo() {
        return 12;
    }

    @Override
    protected char generateCharacter() {
        return 'h';
    }
}
