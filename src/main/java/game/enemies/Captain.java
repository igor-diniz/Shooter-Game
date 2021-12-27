package game.enemies;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Captain extends Enemy {
    public Captain(Position position) {
        super(position);
    }

    @Override
    protected int generateHealth() {
        return 3;
    }

    @Override
    protected Weapon generateWeapon() {
        return new HandCannon();
    }

    @Override
    public void draw(TextGraphics graphics) {

    }
}
