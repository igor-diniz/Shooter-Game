package game.weapons;

import game.Bullet;
import game.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Weapon implements Entity
{
    private int damage;
    private int range;
    private int ammo;
    private List<Bullet> bullets;
    //private int projectileVelocity;

    protected Weapon(int damage,int range,int ammo)
    {
        this.damage = damage;
        this.range = range;
        this.ammo = ammo;
        bullets = new ArrayList<Bullet>();
    }

    public void shoot() {
        if(ammo > 0) {
            decreaseAmmo();
            bullets.add(new Bullet(range));
        }
    }

    public void decreaseAmmo()
    {
        ammo--;
    }

    public int getAmmo(){return ammo;}

    public void setAmmo(int ammo) {this.ammo = ammo;}
}
