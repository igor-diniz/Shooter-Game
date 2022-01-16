package game.enemies.strategy;

import game.Level;
import game.MovingEntity;
import game.enemies.Enemy;

public class GetInRangeStrategy implements MoveStrategy{
    @Override
    public void move(Enemy enemy, Level level, MovingEntity entity) {
        if(enemy.getPosition().distanceTo(entity.getPosition()) > enemy.getWeapon().getRange())
        {
            TrackStrategy trackStrategy = new TrackStrategy();
            trackStrategy.move(enemy,level,entity);
            return;
        }
        char direction = enemy.getMinimalDirectionTo(entity,level);
        enemy.setDirection(direction);
    }
}
