package game.enemies;

import game.Entity;
import game.Position;
import game.weapons.Weapon;

public abstract class Enemy extends Entity {
    private int health;
    private Weapon weapon;
    private int actionDelay; //this represents how many frames of the game the enemy takes to do an action
    private int timer; //when timer == actonDelay, the enemy do an action

    public Enemy(Position position){
        super(position);
        this.health = generateHealth();
        this.weapon = generateWeapon();
        this.actionDelay = generateActionDelay();
        timer = actionDelay;
    }

    public void getDamaged(int damage)
    {
        if(health > damage) health -= damage;
        else health = 0;
    }

    protected abstract int generateActionDelay();

    public Weapon getWeapon(){return weapon;}

    protected abstract int generateHealth();

    protected abstract Weapon generateWeapon();

    public int getHealth() {return health;}

    public void setHealth(int newHealth) {health = newHealth;}

    public int getRemainingTime() { return actionDelay - timer; }
}

