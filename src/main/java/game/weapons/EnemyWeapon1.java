package game.weapons;

public class EnemyWeapon1 extends Weapon {
    @Override
    protected char generateType() {
        return 0;
    }

    @Override
    protected String generateName() {
        return null;
    }

    @Override
    protected int generateDamage() {
        return 10;
    }

    @Override
    protected int generateRange() {
        return 5;
    }

    @Override
    protected int getStartAmmo() {
        return -1;
    }

}
