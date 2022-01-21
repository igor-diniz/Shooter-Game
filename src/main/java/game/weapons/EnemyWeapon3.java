package game.weapons;

public class EnemyWeapon3 extends Weapon {
    public EnemyWeapon3() {
        super();
    }

    @Override
    protected char generateBulletChar() {
        return 'l';
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
    protected int generateDamage() {return 20;}

    @Override
    protected int generateRange() {
        return 10;
    }

    @Override
    protected int getStartAmmo() {return -1;}
}

