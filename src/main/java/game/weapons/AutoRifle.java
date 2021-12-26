package game.weapons;

public class AutoRifle extends PrimaryWeapon {


    public AutoRifle(int damage, int range, int ammo) {
        super(damage, range, ammo);
    }

    @Override
    public void shoot() {
        decreaseAmmo();
    }
}
