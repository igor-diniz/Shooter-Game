package game.weapons;

public class MachineGun extends Weapon{
    @Override
    protected int generateDamage() {return 70;}

    @Override
    protected int generateRange() {
        return 5;
    }

    @Override
    protected int getStartAmmo() {return 12;}
}
