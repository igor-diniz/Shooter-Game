package game.weapons;

import game.entities.Bullet;

public abstract class Weapon
{
    private final int damage;
    private final int range;
    private int ammo;
    private final String name;
    private final char type;
    private final Bullet bullet;

    protected Weapon() {
        this.damage = generateDamage();
        this.range = generateRange();
        this.ammo = getStartAmmo();
        this.name = generateName();
        this.type = generateType();
        this.bullet = generateBullet();
    }

    protected abstract Bullet generateBullet();

    public String getName() {return name;}

    protected abstract char generateType();

    protected abstract String generateName();

    protected abstract int generateDamage();

    protected abstract int generateRange();

    protected abstract int getStartAmmo();

    public Bullet shoot() {
        if(ammo != 0) {
            decreaseAmmo();
            return bullet;
        }
        return null;
    }

    public void decreaseAmmo()
    {
        if(ammo > 0) ammo--;
    }

    public int getAmmo(){return ammo;}

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public char getType() {
        return type;
    }
}
