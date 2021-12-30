package game.weapons;
public abstract class Weapon
{
    private final char character;
    private final int damage;
    private final int range;
    private int ammo;
    //private int projectileVelocity;

    protected Weapon()
    {
        this.damage = generateDamage();
        this.range = generateRange();
        this.ammo = getStartAmmo();
        this.character = generateCharacter();
    }
    protected abstract char generateCharacter();

    protected abstract int generateDamage();

    protected abstract int generateRange();

    protected abstract int getStartAmmo();

    public boolean shoot() {
        if(ammo > 0) {
            decreaseAmmo();
            return true;
        }
        return false;
    }

    public void decreaseAmmo()
    {
        ammo--;
    }

    public int getAmmo(){return ammo;}

    public void setAmmo(int ammo) {this.ammo = ammo;}

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public char getCharacter() {
        return character;
    }
}
