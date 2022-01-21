package game.weapons;

public class EnemyWeapon1 extends Weapon {
    public EnemyWeapon1() {
        super();
    }

    @Override
    protected char generateBulletChar() {
        return 'b';
    }

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
