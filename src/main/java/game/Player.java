package game;

import game.weapons.*;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity
{
    private int health;
    private Weapon primaryWeapon = new HandCannon();
    private Weapon specialWeapon = new Shotgun();
    private Weapon heavyWeapon = new RocketLauncher();
    private int weaponInUse;
    Player(Position position)
    {
        super(position);
        this.health = 3;
        weaponInUse = 0;
    }

    @Override
    protected int generateActionDelay() {
        return 0;
    }

    @Override
    protected char generateCharacter() {
        return 'p';
    }

    public void setWeaponInUse(int index) {weaponInUse = index;}

    public void getDamaged(int damage)
    {
        if(health > damage) health -= damage;
        else health = 0;
    }

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

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health;}

    public Weapon getHeavyWeapon() {
        return heavyWeapon;
    }

    public void setHeavyWeapon(Weapon heavyWeapon) {
        this.heavyWeapon = heavyWeapon;
    }

    public Weapon getSpecialWeapon() {
        return specialWeapon;
    }

    public Weapon getPrimaryWeapon() {
        return primaryWeapon;
    }

    public void setPrimaryWeapon(Weapon primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }

    public void setSpecialWeapon(Weapon specialWeapon) {
        this.specialWeapon = specialWeapon;
    }
}
