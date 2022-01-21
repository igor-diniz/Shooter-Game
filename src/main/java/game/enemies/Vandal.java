package game.enemies;

import game.entities.Position;

import game.weapons.EnemyWeapon2;

import game.enemies.strategy.GetInRangeStrategy;
import game.enemies.strategy.MoveStrategy;
import game.weapons.Weapon;

public class Vandal extends Enemy {
    public Vandal(Position position) {
        super(position);
        //this.setColor("#1064ad");
    }

    @Override
    protected int generateActionDelay() {
        return 25;
    }

    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new GetInRangeStrategy();
    }

    @Override
    protected int generateHealth() {
        return 60;
    }

    @Override
    protected char generateCharacter() {
        return 'v';
    }

    @Override
    protected Weapon generateWeapon() {
        return new EnemyWeapon2();
    }

    @Override
    protected String generateColor() {
        return "#1064ad";
    }

}
