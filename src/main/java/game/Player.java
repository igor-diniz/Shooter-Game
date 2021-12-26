package game;

import game.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private int health;
    private List<Weapon> weapons;
    private Position position;
    Player(Position position)
    {
        this.position = position;
        this.health = 1;
        weapons = new ArrayList<>();
    }

    public void moveUp() { position.moveUp(); }

    public void moveDown() { position.moveDown();}

    public void moveLeft() { position.moveLeft(); }

    public void moveRight() { position.moveRight();}

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health;}

    public List<Weapon> getWeapons() { return weapons;}

    public void setWeapons(List<Weapon> weapons) { this.weapons = weapons;}

    public Position getPosition() { return position;}

    public void setPosition(Position position) { this.position = position; }
}
