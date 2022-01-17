package game.menus;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Game;
import game.Level;

public class PlayState implements State
{
    private final Game game;
    private final Level level;

    public PlayState(Game game)
    {
        this.game = game;
        this.level = game.getLevel();
    }

    @Override
    public void show(TextGraphics graphics) {
        level.moveEnemies();
        level.moveBullets();
        level.checkCollisions();
        level.draw(graphics);
        level.healPlayer();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, graphics.getSize().getRows()-3),new TerminalSize(graphics.getSize().getColumns(),3),' ');
        graphics.putString(new TerminalPosition(0, graphics.getSize().getRows()-3),"HEALTH :" + level.getPlayer().getHealth());
        graphics.putString(new TerminalPosition(0, graphics.getSize().getRows()-2),"WEAPON :" + level.getPlayer().getUsingWeapon().getName());
        graphics.putString(new TerminalPosition(0, graphics.getSize().getRows()-1),"AMMO :" + level.getPlayer().getUsingWeapon().getAmmo());
    }

    @Override
    public void processInput(KeyStroke key) {
        if(key == null) return;
        if (key.getKeyType() == KeyType.EOF) {
            //gameOver = true;
            return;
        }
        if(key.getKeyType() != KeyType.Character) return;
        if(key.getCharacter() == 'i' || key.getCharacter() == 'I') game.setState(new InventoryState(game));
        level.processKey(key);
    }

    public Level getLevel() {return level;}
}
