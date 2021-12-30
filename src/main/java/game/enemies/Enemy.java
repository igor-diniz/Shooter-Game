package game.enemies;

import game.Entity;
import game.Position;
import game.weapons.Weapon;

public abstract class Enemy implements Entity {
    private int health;
    private Position position;
    private Weapon weapon;

    public Enemy(Position position){ //which enemy he is will determine his health
        this.health = generateHealth();
        this.position = position;
        this.weapon = generateWeapon();
    }

    public void getDamaged(int damage)
    {
        if(health > damage) health -= damage;
        else health = 0;
    }

    public Weapon getWeapon(){return weapon;}

    protected abstract int generateHealth();

    protected abstract Weapon generateWeapon();

    public int getHealth() {return health;}

    public void setHealth(int newHealth) {health = newHealth;}

    public void moveUp() { position.moveUp(); }

    public void moveDown() { position.moveDown();}

    public void moveLeft() { position.moveLeft(); }

    public void moveRight() { position.moveRight();}

    public Position getPosition() { return position;}

    public void setPosition(Position position) { this.position = position; }

}

