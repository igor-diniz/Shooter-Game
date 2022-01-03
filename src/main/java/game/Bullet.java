package game;


import game.weapons.Weapon;

public class Bullet extends Entity{
    private int range;
    private final int damage;
    public Bullet(Position position, Weapon weapon, char direction) {
        super(position);
        this.setDirection(direction);
        damage = weapon.getDamage();
        range = weapon.getRange();
    }

    @Override
    protected int generateActionDelay() {
        return 0;
    }

    @Override
    protected char generateCharacter() {
        return 'o';
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

    public void move()
    {
        switch(getDirection())
        {
            case 'N':
                this.setPosition(this.moveUp()); break;
            case 'E':
                this.setPosition(this.moveRight()); break;
            case 'W':
                this.setPosition(this.moveLeft()); break;
            case 'S':
                this.setPosition(this.moveDown()); break;
        }
    }
}
