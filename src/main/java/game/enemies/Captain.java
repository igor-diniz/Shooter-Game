package game.enemies;

import game.Position;
import game.weapons.EnemyWeapon3;
import game.enemies.strategy.MoveStrategy;
import game.enemies.strategy.TrackStrategy;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Captain extends Enemy {
    public Captain(Position position) {
        super(position);
        //this.setColor("#1064ad");
    }

    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new TrackStrategy();
    }

    @Override
    protected int generateActionDelay() { return 35; }

    @Override
    protected char generateCharacter() {
        return 'c';
    }

    @Override
    protected int generateHealth() {
        return 100;
    }

    @Override
    protected Weapon generateWeapon() {
        return new EnemyWeapon3();
    }

    @Override
    protected String generateColor() {
        return "#1064ad";
    }

}
