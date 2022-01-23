package game.enemies;

import game.enemies.strategy.TrackStrategy;
import game.entities.Position;
import game.enemies.strategy.BlindStrategy;
import game.enemies.strategy.MoveStrategy;
import game.weapons.EnemyWeapon2;
import game.weapons.Weapon;

public class Acolyte extends Enemy {
    public Acolyte(Position position) {
        super(position);
    }

    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new TrackStrategy();
    }

    @Override
    protected int generateActionDelay() {return 25;}

    @Override
    protected char generateCharacter() {
        return 'a';
    }

    @Override
    protected int generateHealth() {
        return 60;
    }

    @Override
    protected Weapon generateWeapon() {
        return new EnemyWeapon2();
    }

    @Override
    protected String generateColor() {
        return "#f27935";
    }
}
