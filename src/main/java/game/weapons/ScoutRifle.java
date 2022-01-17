package game.weapons;

public class ScoutRifle extends Weapon {
    @Override
    protected char generateType() {
        return 'S';
    }

    @Override
    protected String generateName() {
        return "SCOUT RIFLE";
    }

    @Override
    protected int generateDamage() {
        return 30;
    }

    @Override
    protected int generateRange() {
        return 10;
    }

    @Override
    protected int getStartAmmo() {
        return -1;
    }
}
