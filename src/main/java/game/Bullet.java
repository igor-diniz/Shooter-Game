package game;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet implements Entity{
    private int range;
    public Bullet(int range) {
        this.range = range;
    }

    @Override
    public void draw(TextGraphics graphics) {
        //range--
    }
}
