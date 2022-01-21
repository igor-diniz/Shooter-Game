package game.weapons;

public class EnemyWeapon2 extends Weapon {
    public EnemyWeapon2() {
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
    protected int generateDamage() {return 15;}

    @Override
    protected int generateRange() {
        return 8;
    }

    @Override
    protected int getStartAmmo() {return -1;}
}
