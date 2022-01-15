package game.enemies.strategy;

import game.Level;
import game.MovingEntity;
import game.enemies.Enemy;

public interface MoveStrategy
{
    void move(Enemy enemy, Level level, MovingEntity entity);
}
