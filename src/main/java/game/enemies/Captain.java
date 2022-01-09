package game.enemies;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Captain extends Enemy {
    public Captain(Position position) {
        super(position);
        //this.setColor("#1064ad");
    }

    @Override
    protected int generateActionDelay() {
        return 4;
    }

    @Override
    protected char generateCharacter() {
        return 'c';
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
    protected String generateColor() {
        return "#1064ad";
    }

}
