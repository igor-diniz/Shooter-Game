package game.weapons;

public class SniperRifle extends Weapon {
    @Override
    protected int generateDamage() {
        return 80;
    }

    @Override
    protected int generateRange() {
        return 10;
    }

    @Override
    protected int getStartAmmo() {return 6;}
}
