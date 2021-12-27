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

    protected Weapon()
    {
        this.damage = getDamage();
        this.range = getRange();
        this.ammo = getStartAmmo();
        bullets = new ArrayList<Bullet>();
    }

    protected abstract int getDamage();

    protected abstract int getRange();

    protected abstract int getStartAmmo();

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
