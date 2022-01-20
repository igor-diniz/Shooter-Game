package game.entities;

public abstract class MovingEntity extends Entity
{
    private final int actionDelay; //this represents how many frames of the game the enemy takes to do an action
    private int timer; //when timer == actonDelay, the enemy do an action
    private char direction = 'N';
    protected int damaged = 0;
    public MovingEntity(Position position)
    {
        super(position);
        this.actionDelay = generateActionDelay();
        timer = actionDelay;
    }
    protected abstract int generateActionDelay();

    public int getDamaged(){return damaged;}

    public void decreaseDamaged(){damaged--;}

    public void increaseTimer()
    {
        timer++;
    }

    public void setTimer(int time)
    {
        timer = time;
    }

    public Position moveUp()
    {
        direction = 'N';
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }

    public Position moveDown()
    {
        direction = 'S';
        return new Position(getPosition().getX(), getPosition().getY() + 1);
    }

    public Position moveRight()
    {
        direction = 'E';
        return new Position(getPosition().getX()+1, getPosition().getY());
    }

    public Position moveLeft()
    {
        direction = 'W';
        return new Position(getPosition().getX()-1, getPosition().getY());
    }

    public int getTimer() {return timer;}

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
    this.direction = direction;
    }

    public int getRemainingTime() { return actionDelay - timer; }

}
