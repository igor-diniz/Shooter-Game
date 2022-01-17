package game;

import game.weapons.*;

import java.util.ArrayList;
import java.util.List;

public class Player extends MovingEntity
{
    private int health;
    private Weapon primaryWeapon = new HandCannon();
    private Weapon specialWeapon = new Shotgun();
    private Weapon heavyWeapon = new NullWeapon();
    private int weaponInUse;
    private int healing;
    private int maxHealth;
    private List<Weapon> inventory;

    Player(Position position)
    {
        super(position);
        this.maxHealth = 150;
        this.health = maxHealth;
        weaponInUse = 0;
        healing = 0;
        inventory = new ArrayList<Weapon>();
        addWeaponToInventory(primaryWeapon);
        addWeaponToInventory(specialWeapon);
        addWeaponToInventory(new RocketLauncher());
    }

    @Override
    protected int generateActionDelay() {
        return 0;
    }

    @Override
    protected char generateCharacter() {
        return 'p';
    }

    public void setWeaponInUse(int index) {
        weaponInUse = index;
    }

    public void takeDamage(int damage)
    {
        if(health > damage) health -= damage;
        else health = 0;
        damaged = 25;
        healing = 60;
    }

    public List<Weapon> getInventory()
    {
        return inventory;
    }

    @Override
    protected String generateColor() {
        return "#000000"; //should be #000000, changed due to draw issue
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

    public void equipWeapon(Weapon weapon)
    {
        switch(weapon.getType())
        {
            case 'P':
                setPrimaryWeapon(weapon); break;
            case 'H':
                setHeavyWeapon(weapon); break;
            case 'S':
                setSpecialWeapon(weapon); break;
        }
    }

    public void addWeaponToInventory(Weapon weapon){inventory.add(weapon);}

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

    public Bullet shoot()
    {
        if(getUsingWeapon().shoot()) return new Bullet(getPosition(),getUsingWeapon(),getDirection(),true);
        return null;
    }

    public int getHealing() {
        return healing;
    }

    public void decreaseHealing() {
        this.healing -= 1;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void increaseHealth(){if(health < maxHealth) {this.health += 1;}}
}
