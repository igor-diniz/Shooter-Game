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
    private List<Bullet> bullets;
    Player(Position position)
    {
        super(position);
        this.health = 3;
        weaponInUse = 0;
        bullets = new ArrayList<Bullet>();
    }

    @Override
    protected char generateCharacter() {
        return 'H';
    }

    public void shoot()
    {
        switch(weaponInUse)
        {
            case 0:
                if(primaryWeapon.shoot()) bullets.add(new Bullet(getPosition(),primaryWeapon.getRange()));;
                break;
            case 1:
                if(specialWeapon.shoot()) bullets.add(new Bullet(getPosition(), specialWeapon.getRange()));;
                break;
            case 2:
                if(heavyWeapon.shoot()) bullets.add(new Bullet(getPosition(),heavyWeapon.getRange()));
                break;
        }
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
