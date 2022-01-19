package game;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Bullet;
import game.Player;
import game.Position;
import game.Wall;
import game.enemies.Enemy;
import game.gui.GUI;

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

    public char getCharacterAt(int column,int row)
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
        level[player.getPosition().getY()][player.getPosition().getX()] = player.getCharacter();
        for (Enemy enemy : enemyList)
        {
            level[enemy.getPosition().getY()][enemy.getPosition().getX()] = enemy.getCharacter();
        }
        for (Wall wall : wallList)
        {
            level[wall.getPosition().getY()][wall.getPosition().getX()] = wall.getCharacter();
        }
    }
    public void draw(GUI gui)
    {
        gui.drawMovingEntity(player);
       // player.draw(graphics);
        for(Enemy enemy: enemyList) gui.drawMovingEntity(enemy); //enemy.draw(graphics);
        //graphics.enableModifiers(SGR.BOLD);
        for(Bullet bullet: bulletList) gui.drawBullet(bullet); //bullet.draw(graphics);
        //graphics.disableModifiers(SGR.BOLD);
        for(Wall wall: wallList) gui.drawImmobileEntity(wall); //wall.draw(graphics) ;
    }

    public void step(GUI gui)
    {
        moveEnemies();
        moveBullets();
        checkCollisions();
        draw(gui);
        healPlayer();
    }

    public void processKey(KeyStroke key)
    {
        char choice = key.getCharacter();
        level[player.getPosition().getY()][player.getPosition().getX()] = 'x';
        switch(choice)
        {
            case 'W': case 'w':
                if(isValidMove(player.moveUp())) player.setPosition(player.moveUp()); break;
            case 'A': case 'a':
                if(isValidMove(player.moveLeft())) player.setPosition(player.moveLeft()); break;
            case 'S': case 's':
                if(isValidMove(player.moveDown())) player.setPosition(player.moveDown()); break;
            case 'D': case 'd':
                if(isValidMove(player.moveRight())) player.setPosition(player.moveRight()); break;
            case 'E': case 'e':
                Bullet bullet = player.shoot();
                if (bullet != null)  bulletList.add(bullet);
                break;
            case '1': player.setWeaponInUse(0); break;
            case '2': player.setWeaponInUse(1); break;
            case '3': player.setWeaponInUse(2); break;
        }
        level[player.getPosition().getY()][player.getPosition().getX()] = 'p';
    }
    public boolean isValidMove(Position position)
    {
        return level[position.getY()][position.getX()] == 'x';
    }

    public Player getPlayer()  {return player;}

    public List<Enemy> getEnemyList() {return enemyList;}

    public boolean isGameOver() {return gameOver;}

    public void moveEnemies()
    {
        for(Enemy enemy : enemyList)
        {
            level[enemy.getPosition().getY()][enemy.getPosition().getX()] = 'x';
            enemy.move(this,player);
            level[enemy.getPosition().getY()][enemy.getPosition().getX()] = enemy.getCharacter();
            if(enemy.getPosition().distanceTo(player.getPosition()) > enemy.getWeapon().getRange()) continue;
            Bullet bullet = enemy.shoot();
            if (bullet != null)  bulletList.add(bullet);
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
                bulletsToRemove.add(bullet);
                continue;
            }
            else if(level[bullet.getPosition().getY()][bullet.getPosition().getX()] == '#')
            {
                bulletsToRemove.add(bullet);
                continue;
            }
            for(Enemy enemy : enemyList)
            {
                if (bullet.getPosition().equals(enemy.getPosition()))
                {
                    enemy.takeDamage(bullet.getDamage(),bullet.isShotByPlayer());
                    if(enemy.getHealth() == 0) {enemiesToRemove.add(enemy); level[enemy.getPosition().getY()][enemy.getPosition().getX()] = 'x';}
                    bulletsToRemove.add(bullet);
                    break;
                }
            }
        }
        for(Bullet bullet: bulletsToRemove) bulletList.remove(bullet);
        for(Enemy enemy : enemiesToRemove) enemyList.remove(enemy);
        if(enemyList.size() == 0 || player.getHealth() == 0) gameOver = true;
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
            level[bullet.getPosition().getY()][bullet.getPosition().getX()] = 'x';
            if(bullet.getRange() > 0)
                bullet.decreaseRange();
            else{
                bulletsToRemove.add(bullet);
                continue;}
            bullet.move();
            if(level[bullet.getPosition().getY()][bullet.getPosition().getX()] == 'x')
            level[bullet.getPosition().getY()][bullet.getPosition().getX()] = 'b';
        }
        for(Bullet bullet: bulletsToRemove) bulletList.remove(bullet);
    }
    public void healPlayer(){
        if (player.getHealing() > 0){player.decreaseHealing();}
        else {player.increaseHealth();}
    }
}
