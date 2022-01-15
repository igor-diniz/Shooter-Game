package game.enemies;

import game.Position;
import game.enemies.strategy.BlindStrategy;
import game.enemies.strategy.MoveStrategy;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Dreg extends Enemy {

    public Dreg(Position position) {
        super(position);
    }

    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new BlindStrategy();
    }

    @Override
    protected int generateActionDelay() { return 1; }

    @Override
    protected char generateCharacter() {
        return 'd';
    }

    @Override
    protected int generateHealth() {
        return 1;
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
