package game.weapons;

public class HandCannon extends Weapon{


    public HandCannon(){

    }

    @Override
    protected int generateDamage() {
        return 40;
    }

    @Override
    protected int generateRange() {
        return 7;
    }

    @Override
    protected int getStartAmmo() {
        return -1;
    }

}
