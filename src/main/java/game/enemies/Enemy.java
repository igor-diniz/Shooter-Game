package game.enemies;

import game.*;
import game.enemies.strategy.MoveStrategy;
import game.weapons.Weapon;

public abstract class Enemy extends MovingEntity {
    private int health;
    private Weapon weapon;
    private MoveStrategy moveStrategy;

    public Enemy(Position position){
        super(position);
        this.moveStrategy = generateMoveStrategy();
        this.health = generateHealth();
        this.weapon = generateWeapon();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy)
    {
        this.moveStrategy = moveStrategy;
    }

    public char getMinimalDirectionTo(Entity entity,Level level)
    {
        char direction = ' ';
        char oldDirection = getDirection();
        double distance = this.getPosition().distanceTo(entity.getPosition());
        if(this.moveUp().distanceTo(entity.getPosition()) < distance)
        {
            distance = this.moveUp().distanceTo(entity.getPosition());
            direction = 'N';
        }
        if(this.moveDown().distanceTo(entity.getPosition()) < distance)
        {
            distance = this.moveDown().distanceTo(entity.getPosition());
            direction = 'S';
        }
        if(this.moveRight().distanceTo(entity.getPosition()) < distance)
        {
            distance = this.moveRight().distanceTo(entity.getPosition());
            direction = 'E';
        }
        if(this.moveLeft().distanceTo(entity.getPosition()) < distance)
        {
            direction = 'W';
        }
        setDirection(oldDirection);
        return direction;
    }

    protected abstract MoveStrategy generateMoveStrategy();

    public void move(Level level, MovingEntity entity)
    {
        if(getRemainingTime() == 0)  {moveStrategy.move(this,level, entity); setTimer(0);}
        else increaseTimer();
    }

    public void takeDamage(int damage,boolean shotByPlayer)
    {
        if(!shotByPlayer) return;
        if(health > damage) health -= damage;
        else health = 0;
        damaged = 25;
    }

    public Bullet shoot()
    {
        if(getTimer() != 0) return null;
        if(weapon.shoot()) return new Bullet(getPosition(),weapon,getDirection(),false);
        return null;
    }

    public Weapon getWeapon(){return weapon;}

    protected abstract int generateHealth();

    protected abstract Weapon generateWeapon();

    public int getHealth() {return health;}

}

