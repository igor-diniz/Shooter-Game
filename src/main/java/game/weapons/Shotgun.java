package game.weapons;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Shotgun extends SpecialWeapon {
    public Shotgun() {
    }

    //private int xAoE; //AoE stands for Area of Effect
   // private int yAoE;

    @Override
    public void draw(TextGraphics graphics) {

    }

    @Override
    protected int getDamage() {
        return 3;
    }

    @Override
    protected int getRange() {
        return 2;
    }

    @Override
    protected int getStartAmmo() {
        return 8;
    }
}