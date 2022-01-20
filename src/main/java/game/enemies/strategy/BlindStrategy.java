package game.enemies.strategy;

import game.Level;
import game.entities.MovingEntity;
import game.enemies.Enemy;

import java.util.Random;

public class BlindStrategy implements MoveStrategy{
    @Override
    public void move(Enemy enemy, Level level, MovingEntity entity) {
        if(enemy.getPosition().distanceTo(entity.getPosition()) <= enemy.getWeapon().getRange())
        {
            enemy.setMoveStrategy(new TrackStrategy());
            enemy.move(level,entity);
            return;
        }
        Random random = new Random();
        int side = random.nextInt(4);
        switch(side)
        {
            case 0:
                if(level.isValidMove(enemy.moveUp())) enemy.setPosition(enemy.moveUp()); return;
            case 1:
                if(level.isValidMove(enemy.moveRight())) enemy.setPosition(enemy.moveRight()); return;
            case 2:
                if(level.isValidMove(enemy.moveLeft())) enemy.setPosition(enemy.moveLeft()); return;
            case 3:
                if(level.isValidMove(enemy.moveDown())) enemy.setPosition(enemy.moveDown()); return;
        }
    }
}
