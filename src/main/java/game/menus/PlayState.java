package game.menus;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import game.Level;

public class PlayState implements State
{
    private final Level level;

    public PlayState(Level level)
    {
        this.level = level;
    }

    @Override
    public void show(TextGraphics graphics) {
        level.moveEnemies();
        level.moveBullets();
        level.checkCollisions();
        level.draw(graphics);
        level.healPlayer();
    }

    @Override
    public void processInput(KeyStroke keystroke) {
        level.processKey(keystroke);
    }

    public Level getLevel() {return level;}
}
