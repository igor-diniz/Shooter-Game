package game.weapons;

public abstract class Weapon
{
    private int damage;
    private int range;
    private int ammo;
    //private int projectileVelocity;

    protected Weapon(int damage,int range,int ammo)
    {
        this.damage = damage;
        this.range = range;
        this.ammo = ammo;
    }
    public abstract void shoot();

    public void decreaseAmmo()
    {
        if(ammo > 0)
        {
            ammo--;
        }
    }

    public int getAmmo(){return ammo;}

    public void setAmmo(int ammo) {this.ammo = ammo;}
}
