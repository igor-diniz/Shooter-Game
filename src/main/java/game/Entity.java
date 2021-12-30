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
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), String.valueOf(character));
    }

    public Position getPosition() { return position;}

    public void moveUp() { position.moveUp(); }

    public void moveDown() { position.moveDown();}

    public void moveLeft() { position.moveLeft(); }

    public void moveRight() { position.moveRight();}

    public void setPosition(Position position) { this.position = position; }
}
