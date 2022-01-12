package game;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import game.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Level
{
    private final int NUM_ROWS;
    private final int NUM_COLUMNS;
    private char[][] level;
    private Player player;
    private List<Enemy> enemyList;
    private List<Wall> wallList;
    private List<Bullet> bulletList = new ArrayList<>();
    private boolean gameOver = false;
    public Level(int numRows,int numColumns)
    {
        NUM_ROWS = numRows;
        NUM_COLUMNS = numColumns;
        level = new char[NUM_ROWS][NUM_COLUMNS];
    }
    public int getNumRows()
    {
        return NUM_ROWS;
    }

    public int getNumColumns()
    {
        return NUM_COLUMNS;
    }

    public char getCharacterAt(int row,int column)
    {
        return level[row][column];
    }

    public void generateEntities(Player player, List<Enemy> enemyList, List<Wall> wallList)
    {
        for(int i = 0; i< NUM_ROWS; i++)
        {
            for(int j = 0; j< NUM_COLUMNS; j++)
            {
                level[i][j] = 'x';
            }
        }
        this.enemyList = enemyList;
        this.player = player;
        this.wallList = wallList;
        level[player.getPosition().getX()][player.getPosition().getY()] = player.getCharacter();
        for (Enemy enemy : enemyList)
        {
            level[enemy.getPosition().getX()][enemy.getPosition().getY()] = enemy.getCharacter();
        }
        for (Wall wall : wallList)
        {
            level[wall.getPosition().getX()][wall.getPosition().getY()] = wall.getCharacter();
        }
    }
    public void draw(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#567D46"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(NUM_COLUMNS, NUM_ROWS), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        player.draw(graphics);
        for(Enemy enemy: enemyList) enemy.draw(graphics);
        graphics.enableModifiers(SGR.BOLD);
        for(Bullet bullet: bulletList) bullet.draw(graphics);
        graphics.disableModifiers(SGR.BOLD);
        for(Wall wall: wallList) wall.draw(graphics);
    }

    public void processKey(KeyStroke key)
    {
        if(key == null) return;
        String a = key.getKeyType().toString();
        level[player.getPosition().getX()][player.getPosition().getY()] = 'x';
        switch(a)
        {
            case "ArrowUp":
                if(isValidMove(player.moveUp())) player.setPosition(player.moveUp()); break;
            case "ArrowLeft":
                if(isValidMove(player.moveLeft())) player.setPosition(player.moveLeft()); break;
            case "ArrowDown":
                if(isValidMove(player.moveDown())) player.setPosition(player.moveDown()); break;
            case "ArrowRight":
                if(isValidMove(player.moveRight())) player.setPosition(player.moveRight()); break;
            case "Enter":
                if(player.getUsingWeapon().getAmmo() > 0) {
                    bulletList.add(new Bullet(player.getPosition(), player.getUsingWeapon(), player.getDirection()));
                    player.getUsingWeapon().decreaseAmmo();
                } break;
        }
        level[player.getPosition().getX()][player.getPosition().getY()] = 'p';
    }
    public boolean isValidMove(Position position)
    {
        return level[position.getX()][position.getY()] == 'x';
    }

    public Player getPlayer()  {return player;}

    public List<Enemy> getEnemyList() {return enemyList;}

    public boolean gameOver() {return gameOver;}

    public void moveEnemies()
    {
        int xDistance, yDistance;
        double oldDistanceToPlayer;
        for(Enemy enemy : enemyList)
        {
            level[enemy.getPosition().getX()][enemy.getPosition().getY()] = 'x';
            xDistance = enemy.getPosition().getX() - player.getPosition().getX();
            yDistance = enemy.getPosition().getY() - player.getPosition().getY();
            oldDistanceToPlayer = enemy.getPosition().distanceTo(player.getPosition());
            if(Math.abs(xDistance) > Math.abs(yDistance))
            {
                if(xDistance > 0 && isValidMove(enemy.moveLeft()))
                {
                    enemy.setPosition(enemy.moveLeft());
                }
                else if(isValidMove(enemy.moveRight()))
                    enemy.setPosition(enemy.moveRight());
            }
            else if(yDistance > 0 && isValidMove(enemy.moveUp()))
            {
                enemy.setPosition(enemy.moveUp());
            }
            else if(isValidMove(enemy.moveDown()))
            {
                enemy.setPosition(enemy.moveDown());
            }
            level[enemy.getPosition().getX()][enemy.getPosition().getY()] = enemy.getCharacter();
            if((enemy.getPosition().distanceTo(player.getPosition()) < enemy.getWeapon().getRange())
            && (enemy.getPosition().distanceTo(player.getPosition()) != oldDistanceToPlayer)) //enemies should only shoot if the player is in their range and the enemy has moved
            bulletList.add(new Bullet(enemy.getPosition(),enemy.getWeapon(),enemy.getDirection()));
        }
    }
    public void checkCollisions()
    {
        List<Bullet> bulletsToRemove = new ArrayList<>();
        List<Enemy> enemiesToRemove = new ArrayList<>();
        for(Bullet bullet : bulletList)
        {
            if(bullet.getPosition().equals(player.getPosition()))
            {
                player.takeDamage(bullet.getDamage());
                if(player.getHealth() == 0) gameOver = true;
                bulletsToRemove.add(bullet);
                continue;
            }
            if(level[bullet.getPosition().getX()][bullet.getPosition().getY()] == '#')
            {
                bulletsToRemove.add(bullet);
                continue;
            }
            for(Enemy enemy : enemyList)
            {
                if (bullet.getPosition().equals(enemy.getPosition()))
                {
                    enemy.takeDamage(bullet.getDamage());
                    if(enemy.getHealth() == 0) {enemiesToRemove.add(enemy); level[enemy.getPosition().getX()][enemy.getPosition().getY()] = 'x';}
                    bulletsToRemove.add(bullet);
                    break;
                }
            }
        }
        for(Bullet bullet: bulletsToRemove) bulletList.remove(bullet);
        for(Enemy enemy : enemiesToRemove) enemyList.remove(enemy);
        if(enemyList.size() == 0) gameOver = true;
    }
    public void addBullet(Bullet bullet)
    {
        bulletList.add(bullet);
    }

    public List<Bullet> getBullets()
    {
        return bulletList;
    }

    public void moveBullets()
    {
        List<Bullet> bulletsToRemove = new ArrayList<>();
        for(Bullet bullet : bulletList)
        {
            level[bullet.getPosition().getX()][bullet.getPosition().getY()] = 'x';
            if(bullet.getRange() > 0)
                bullet.decreaseRange();
            else{
                bulletsToRemove.add(bullet);
                continue;}
            bullet.move();
            if(level[bullet.getPosition().getX()][bullet.getPosition().getY()] == 'x')
            level[bullet.getPosition().getX()][bullet.getPosition().getY()] = 'b';
        }
        for(Bullet bullet: bulletsToRemove) bulletList.remove(bullet);
    }
}
