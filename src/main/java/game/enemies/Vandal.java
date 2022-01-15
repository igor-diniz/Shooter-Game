package game.enemies;

import game.Position;
import game.enemies.strategy.GetInRangeStrategy;
import game.enemies.strategy.MoveStrategy;
import game.enemies.strategy.TrackStrategy;
import game.weapons.HandCannon;
import game.weapons.Weapon;

public class Vandal extends Enemy {
    public Vandal(Position position) {
        super(position);
        //this.setColor("#1064ad");
    }

    @Override
    protected int generateActionDelay() {
        return 3;
    }

    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new GetInRangeStrategy();
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

    @Override
    protected String generateColor() {
        return "#1064ad";
    }

}
