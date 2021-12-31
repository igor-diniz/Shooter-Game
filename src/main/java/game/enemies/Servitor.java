package game.enemies;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Servitor extends Enemy {
    public Servitor(Position position) {
        super(position);
    }

    @Override
    protected char generateCharacter() {
        return 's';
    }

    @Override
    protected int generateHealth() {
        return 3;
    }

    @Override
    protected Weapon generateWeapon() {
        return new HandCannon();
    }

}
