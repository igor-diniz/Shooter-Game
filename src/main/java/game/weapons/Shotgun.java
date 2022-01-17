package game.weapons;

public class Shotgun extends Weapon {

    public Shotgun() {}

    @Override
    protected int generateDamage() {
        return 80;
    }

    @Override
    protected int generateRange() {
        return 2;
    }

    @Override
    protected int getStartAmmo() {
        return 5;
    }
}