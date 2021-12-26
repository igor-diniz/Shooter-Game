package game.enemies;

import game.Position;

public abstract class Enemy {
    private int health;
    private Position position;

    public Enemy(int health, Position position){ //which enemy he is will determine his health
        this.health = health;
        this.position = position;
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

