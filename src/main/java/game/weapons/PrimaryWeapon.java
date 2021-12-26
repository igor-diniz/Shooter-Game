package game.weapons;

public abstract class PrimaryWeapon extends Weapon{
    protected PrimaryWeapon(int damage, int range, int ammo) {
        super(damage, range, ammo);
    }
}
