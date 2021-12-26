package game;

public abstract class Weapon
{
    private int damage;
    private int range;
    private int projectileVelocity;

    protected Weapon(int damage,int range)
    {
        this.damage = damage;
        this.range = range;
    }
    public abstract void shoot();
}
