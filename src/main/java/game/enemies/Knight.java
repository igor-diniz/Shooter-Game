package game.enemies;

import game.entities.Position;
import game.enemies.strategy.BlindStrategy;
import game.enemies.strategy.MoveStrategy;
import game.weapons.EnemyWeapon3;
import game.weapons.Weapon;

public class Knight extends Enemy {
    public Knight(Position position) {
        super(position);
    }

    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new BlindStrategy();
    }

    @Override
    protected int generateActionDelay() {return 35;}

    @Override
    protected int generateHealth() {
        return 100;
    }

    @Override
    protected char generateCharacter() {
        return 'k';
    }

    @Override
    protected Weapon generateWeapon() {
        return new EnemyWeapon3();
    }

    @Override
    protected String generateColor() {
        return "#f27935";
    }
}
