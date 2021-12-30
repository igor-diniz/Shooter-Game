package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.weapons.*;

import java.util.ArrayList;
import java.util.List;

public class Player implements Entity
{
    private int health;
    private PrimaryWeapon primaryWeapon = new HandCannon();
    private SpecialWeapon specialWeapon = new Shotgun();
    private HeavyWeapon heavyWeapon = new RocketLauncher();
    private Position position;
    private int weaponInUse;
    Player(Position position)
    {
        this.position = position;
        this.health = 3;
        weaponInUse = 0;
    }

    public char getCharacter()
    {
        //
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

    @Override
    public void draw(TextGraphics graphics)
    {
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}
