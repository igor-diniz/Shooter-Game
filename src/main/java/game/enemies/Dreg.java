package game.enemies;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Dreg extends Enemy {
    public Dreg(Position position) {
        super(position);
    }

    @Override
    public void draw(TextGraphics graphics) {

    }

    @Override
    protected int generateHealth() {
        return 1;
    }

    @Override
    protected Weapon generateWeapon() {
        return new HandCannon();
    }
}
