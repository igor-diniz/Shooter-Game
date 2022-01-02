package game;


import game.weapons.Weapon;

public class Bullet extends Entity{
    private int range;
    private final int damage;
    public Bullet(Position position, Weapon weapon) {
        super(position);
        damage = weapon.getDamage();
        range = weapon.getRange();
    }

    @Override
    protected char generateCharacter() {
        return 'b';
    }

    public boolean decreaseRange()
    {
        if(range > 0){ range --; return true;}
        return false;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }
}
