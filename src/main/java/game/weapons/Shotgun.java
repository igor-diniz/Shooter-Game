package game.weapons;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Player;

public class Shotgun extends Weapon {
    public Shotgun() {

    }

    @Override
    protected char generateCharacter() {
        return 'S';
    }

    @Override
    protected int generateDamage() {
        return 3;
    }

    @Override
    protected int generateRange() {
        return 2;
    }

    @Override
    protected int getStartAmmo() {
        return 8;
    }
}