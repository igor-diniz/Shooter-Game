package game.enemies;

import game.entities.Position;
import game.enemies.strategy.BlindStrategy;
import game.enemies.strategy.MoveStrategy;
import game.weapons.EnemyWeapon1;
import game.weapons.Weapon;

public class Thrall extends Enemy {
    public Thrall(Position position) {
        super(position);
    }

    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new BlindStrategy();
    }

    @Override
    protected int generateActionDelay() {return 15;}

    @Override
    protected char generateCharacter() {
        return 't';
    }

    @Override
    protected int generateHealth() {
        return 30;
    }

    @Override
    protected Weapon generateWeapon() {
        return new EnemyWeapon1();
    }

    @Override
    protected String generateColor() {
        return "#f27935";
    }

}
