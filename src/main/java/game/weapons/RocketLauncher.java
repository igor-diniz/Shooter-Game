package game.weapons;


public class RocketLauncher extends Weapon {

    public RocketLauncher() {
        super();
    }

    @Override
    protected char generateBulletChar() {
        return 'm';
    }

    @Override
    protected char generateType() {
        return 'H';
    }

    @Override
    protected String generateName() {
        return "ROCKET LAUNCHER";
    }

    @Override
    protected int generateDamage() {
        return 150;
    }

    @Override
    protected int generateRange() {
        return 10;
    }

    @Override
    protected int getStartAmmo() {
        return 1;
    }
}
