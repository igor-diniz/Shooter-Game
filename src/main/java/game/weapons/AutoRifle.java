package game.weapons;

public class AutoRifle extends Weapon {
    public AutoRifle() {
        super();
    }

    @Override
    protected char generateBulletChar() {
        return 'b';
    }

    @Override
    protected char generateType() {
        return 'P';
    }

    @Override
    protected String generateName() {
        return "AUTO RIFLE";
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
