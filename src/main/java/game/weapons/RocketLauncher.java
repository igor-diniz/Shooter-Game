package game.weapons;

import com.googlecode.lanterna.graphics.TextGraphics;

public class RocketLauncher extends HeavyWeapon {
    //private int xAoE; //AoE stands for Area of Effect
    //private int yAoE;

    public RocketLauncher() {
    }

    @Override
    protected int getDamage() {
        return 5;
    }

    @Override
    protected int getRange() {
        return 3;
    }

    @Override
    protected int getStartAmmo() {
        return 5;
    }

    @Override
    public void draw(TextGraphics graphics) {

    }
}
