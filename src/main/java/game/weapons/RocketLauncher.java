package game.weapons;

import com.googlecode.lanterna.graphics.TextGraphics;

public class RocketLauncher extends HeavyWeapon {
    //private int xAoE; //AoE stands for Area of Effect
    //private int yAoE;

    public RocketLauncher(int damage, int range, int ammo) {
        super(damage, range, ammo);
    }

    @Override
    public void draw(TextGraphics graphics) {

    }
}
