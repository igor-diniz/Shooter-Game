package game;

import game.weapons.*;

public class Player
{
    private int health;
    private PrimaryWeapon primaryWeapon = new AutoRifle(1,5,10);
    private SpecialWeapon specialWeapon = new Shotgun(3,2,8);
    private HeavyWeapon heavyWeapon = new LightMachineGun(2,6,30);
    private Position position;
    private int weaponInUse;
    Player(Position position)
    {
        this.position = position;
        this.health = 1;
        weaponInUse = 0;
    }

    public void shoot()
    {
        switch(weaponInUse)
        {
            case 0:
                primaryWeapon.shoot();
                break;
            case 1:
                specialWeapon.shoot();
                break;
            case 2:
                heavyWeapon.shoot();
                break;
        }
    }
    public void setWeaponInUse(int index) {weaponInUse = index;}

    public Weapon getUsingWeapon()
    {
        switch(weaponInUse)
        {
            case 0:
                return primaryWeapon;
            case 1:
                return specialWeapon;
            case 2:
                return heavyWeapon;
            default:
                return null;
        }
    }

    public void moveUp() { position.moveUp(); }

    public void moveDown() { position.moveDown();}

    public void moveLeft() { position.moveLeft(); }

    public void moveRight() { position.moveRight();}

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health;}

    public Position getPosition() { return position;}

    public void setPosition(Position position) { this.position = position; }

    public HeavyWeapon getHeavyWeapon() {
        return heavyWeapon;
    }

    public void setHeavyWeapon(HeavyWeapon heavyWeapon) {
        this.heavyWeapon = heavyWeapon;
    }

    public SpecialWeapon getSpecialWeapon() {
        return specialWeapon;
    }

    public PrimaryWeapon getPrimaryWeapon() {
        return primaryWeapon;
    }

    public void setPrimaryWeapon(PrimaryWeapon primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }

    public void setSpecialWeapon(SpecialWeapon specialWeapon) {
        this.specialWeapon = specialWeapon;
    }
}
