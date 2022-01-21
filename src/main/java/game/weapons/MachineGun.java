package game.weapons;

public class MachineGun extends Weapon{

    @Override
    protected char generateBulletChar() {
        return 'l';
    }

    @Override
    protected char generateType() {
        return 'H';
    }

    @Override
    protected String generateName() {
        return "MACHINE GUN";
    }

    @Override
    protected int generateDamage() {return 70;}

    @Override
    protected int generateRange() {
        return 5;
    }

    @Override
    protected int getStartAmmo() {return 25;}
}
