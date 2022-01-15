package game.weapons;

public class MachineGun extends Weapon{
    @Override
    protected int generateDamage() {
        return 0;
    }

    @Override
    protected int generateRange() {
        return 0;
    }

    @Override
    protected int getStartAmmo() {return 0;}
}
