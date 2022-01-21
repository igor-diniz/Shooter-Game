package game.weapons;

public class ScoutRifle extends Weapon {

    @Override
    protected String generateName() {
        return "SCOUT RIFLE";
    }

    @Override
    protected char generateType() {
        return 'P';
    }

    @Override
    protected char generateBulletChar() {
        return 'b';
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
