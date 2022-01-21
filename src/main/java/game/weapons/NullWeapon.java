package game.weapons;

public class NullWeapon extends Weapon{

    @Override
    protected char generateBulletChar() {
        return 'b';
    }

    @Override
    protected char generateType() {
        return ' ';
    }

    @Override
    protected String generateName() {
        return " ";
    }

    @Override
    protected int generateDamage() {
        return 0;
    }

    @Override
    protected int generateRange() {
        return 0;
    }

    @Override
    protected int getStartAmmo() {
        return 0;
    }
}
