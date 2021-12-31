package game.enemies;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Vandal extends Enemy {
    public Vandal(Position position) {
        super(position);
    }

    @Override
    protected char generateCharacter() {
        return 'v';
    }

    @Override
    protected int generateHealth() {
        return 2;
    }

    @Override
    protected Weapon generateWeapon() {
        return new HandCannon();
    }

}
