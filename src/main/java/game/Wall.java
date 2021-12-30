package game;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall implements Entity {

    private Position position;
    private final char character = 'W';
    public Wall(Position position)
    {
        this.position = position;
    }

    public char getCharacter()
    {
        return character;
    }

    @Override
    public void draw(TextGraphics graphics) {

    }

    public Position getPosition() { return position;}
}
