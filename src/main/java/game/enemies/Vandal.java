package game.enemies;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Vandal extends Enemy {
    public Vandal(Position position) {
        super(position);
        //this.setColor("#1064ad");
    }

    @Override
    protected int generateActionDelay() {
        return 6;
    }

    @Override
    protected char generateCharacter() {
        return 'v';
    }

    @Override
    protected int generateHealth() {
        return 60;
    }

    @Override
    protected Weapon generateWeapon() {
        return new HandCannon();
    }

    @Override
    protected String generateColor() {
        return "#1064ad";
    }

}
