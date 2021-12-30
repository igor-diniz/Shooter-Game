package game;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet extends Entity{
    private int range;
    public Bullet(Position position,int range) {
        super(position);
        this.range = range;
    }

    @Override
    protected char generateCharacter() {
        return 'B';
    }

    @Override
    public void draw(TextGraphics graphics) {
        //do something
        range--;
    }

    public int getRange() {
        return range;
    }
}
