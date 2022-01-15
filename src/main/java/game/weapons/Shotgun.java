package game.weapons;

public class Shotgun extends Weapon {
    public Shotgun() {

    }

    @Override
    protected int generateDamage() {
        return 3;
    }

    @Override
    protected int generateRange() {
        return 2;
    }

    @Override
    protected int getStartAmmo() {
        return 8;
    }
}