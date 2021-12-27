package game.enemies;

import game.Bullet;
import game.Entity;
import game.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy implements Entity {
    private int health;
    private Position position;

    public Enemy(int health, Position position){ //which enemy he is will determine his health
        this.health = health;
        this.position = position;
    }

    public void getDamaged(int damage)
    {
        if(health > damage) health -= damage;
        else health = 0;
    }

    public int getHealth() {return health;}

    public void setHealth(int newHealth) {health = newHealth;}

    public void moveUp() { position.moveUp(); }

    public void moveDown() { position.moveDown();}

    public void moveLeft() { position.moveLeft(); }

    public void moveRight() { position.moveRight();}

    public Position getPosition() { return position;}

    public void setPosition(Position position) { this.position = position; }

}

