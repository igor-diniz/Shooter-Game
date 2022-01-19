package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class ImmobileEntity extends Entity
{
    protected ImmobileEntity(Position position) {
        super(position);
    }
}
