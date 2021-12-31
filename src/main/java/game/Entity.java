package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Entity {
    private Position position;
    private final char character;

    protected Entity(Position position)
    {
        this.position = position;
        character = generateCharacter();
    }

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
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown()
    {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveRight()
    {
        return new Position(position.getX()+1, position.getY());
    }

    public Position moveLeft()
    {
        return new Position(position.getX()-1, position.getY());
    }

    public void setPosition(Position position) { this.position = position; }
}
