package game.weapons;

public class Shotgun extends Weapon {

    public Shotgun() {
        super();
    }

    @Override
    protected char generateBulletChar() {
        return 'i';
    }
    @Override
    protected char generateType() {
        return 'S';
    }

    @Override
    protected String generateName() {
        return "SHOTGUN";
    }

    @Override
    protected int generateDamage() {
        return 80;
    }

    @Override
    protected int generateRange() {
        return 2;
    }

    @Override
    protected int getStartAmmo() {
        return 5;
    }
}