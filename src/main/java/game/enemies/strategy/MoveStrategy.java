package game.enemies.strategy;

import game.Level;
import game.entities.MovingEntity;
import game.enemies.Enemy;

public interface MoveStrategy
{
    void move(Enemy enemy, Level level, MovingEntity entity);
}
