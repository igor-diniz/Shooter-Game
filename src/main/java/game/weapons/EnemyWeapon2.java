package game.weapons;

public class EnemyWeapon2 extends Weapon {
    @Override
    protected int generateDamage() {return 15;}

    @Override
    protected int generateRange() {
        return 8;
    }

    @Override
    protected int getStartAmmo() {return -1;}
}
