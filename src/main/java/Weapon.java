public abstract class Weapon
{
    private int damage;
    private int range;
    protected Weapon(int damage,int range)
    {
        this.damage = damage;
        this.range = range;
    }
    public abstract void shoot();
}
