package game.weapons;

public class EnemyWeapon2 extends Weapon {

    @Override
    protected char generateBulletChar() {
        return 'b';
    }

    @Override
    protected char generateType() {
        return 'm';
    }

    @Override
    protected String generateName() {
        return "ENEMY WEAPON 2";
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
