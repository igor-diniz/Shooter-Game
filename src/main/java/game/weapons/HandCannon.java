package game.weapons;

import com.googlecode.lanterna.graphics.TextGraphics;

public class HandCannon extends PrimaryWeapon{


    public HandCannon(){}

    @Override
    protected int getDamage() {
        return 1;
    }

    @Override
    protected int getRange() {
        return 5;
    }

    @Override
    protected int getStartAmmo() {
        return 12;
    }

    ;


    @Override
    public void draw(TextGraphics graphics) {

    }
}
