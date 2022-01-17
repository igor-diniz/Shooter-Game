package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class ImmobileEntity extends Entity
{
    protected ImmobileEntity(Position position) {
        super(position);
    }

    @Override
    protected void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(getColor()));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), String.valueOf(getCharacter()));
    }
}
