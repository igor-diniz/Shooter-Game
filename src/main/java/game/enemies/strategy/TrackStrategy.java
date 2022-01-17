package game.enemies.strategy;

import game.Level;
import game.MovingEntity;
import game.enemies.Enemy;

public class TrackStrategy implements MoveStrategy
{
    @Override
    public void move(Enemy enemy, Level level, MovingEntity entity) {
        char direction = enemy.getMinimalDirectionTo(entity,level);
        switch(direction)
        {
            case 'N':
                if(level.isValidMove(enemy.moveUp())) enemy.setPosition(enemy.moveUp()); break;
            case 'W':
                if(level.isValidMove(enemy.moveLeft()))  enemy.setPosition(enemy.moveLeft()); break;
            case 'S':
                if(level.isValidMove(enemy.moveDown()))  enemy.setPosition(enemy.moveDown()); break;
            case 'E':
                if(level.isValidMove(enemy.moveRight()))  enemy.setPosition(enemy.moveRight()); break;
        }
    }
}
