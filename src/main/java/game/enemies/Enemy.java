package game.enemies;

import game.Entity;
import game.Position;
import game.weapons.Weapon;

public abstract class Enemy extends Entity {
    private int health;
    private Weapon weapon;

    public Enemy(Position position){
        super(position);
        this.health = generateHealth();
        this.weapon = generateWeapon();
    }

    public void takeDamage(int damage)
    {
        if(health > damage) health -= damage;
        else health = 0;
        damaged = 25;
    }

    public Weapon getWeapon(){return weapon;}

    protected abstract int generateHealth();

    protected abstract Weapon generateWeapon();

    public int getHealth() {return health;}

    public void setHealth(int newHealth) {health = newHealth;}

}

