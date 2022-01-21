package game.weapons;

public class AutoRifle extends Weapon {

    @Override
    protected char generateBulletChar() {
        return 'b';
    }

    @Override
    protected String generateName() {
        return "AUTO RIFLE";
    }

    @Override
    protected char generateType() {
        return 'P';
    }

    @Override
    protected int generateDamage() {
        return 20;
    }

    @Override
    protected int generateRange() {
        return 4;
    }

    @Override
    protected int getStartAmmo() {
        return -1;
    }
}
