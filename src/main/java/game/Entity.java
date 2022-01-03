package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Entity {
    private Position position;
    private final char character;
    private char direction = 'N';
    private final int actionDelay; //this represents how many frames of the game the enemy takes to do an action
    private int timer; //when timer == actonDelay, the enemy do an action


    protected Entity(Position position)
    {
        this.position = position;
        character = generateCharacter();
        this.actionDelay = generateActionDelay();
        timer = actionDelay;
    }

    protected abstract int generateActionDelay();

    protected abstract char generateCharacter();

    public char getCharacter()
    {
        return character;
    }

    public void draw(TextGraphics graphics)
    {
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), String.valueOf(character));
    }

    public Position getPosition() { return position;}

    public Position moveUp()
    {
        direction = 'N';
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown()
    {
        direction = 'S';
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveRight()
    {
        direction = 'E';
        return new Position(position.getX()+1, position.getY());
    }

    public Position moveLeft()
    {
        direction = 'W';
        return new Position(position.getX()-1, position.getY());
    }

    public void setPosition(Position position)
    {
        if(getRemainingTime() == 0)  {this.position = position; timer = 0;}
        else timer++;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getRemainingTime() { return actionDelay - timer; }

    public int getActionDelay() {return actionDelay;}
}
