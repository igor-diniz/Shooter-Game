package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import game.enemies.Dreg;
import game.enemies.Enemy;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game
{
    private Screen screen;
    private Level level;
    private Terminal terminal;
    public Game() throws IOException {
        loadLevel1();
        Font font = new Font("WenQuanYi Zen Hei Mono", Font.BOLD, 24);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
        TerminalSize terminalSize = new TerminalSize(level.getNumColumns(), level.getNumRows());
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize)
                .setTerminalEmulatorFontConfiguration(cfg).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    private void draw() throws IOException {
        screen.clear();
        level.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException, InterruptedException {
        while(!level.gameOver())
        {
            Thread.sleep(5);
            draw();
            KeyStroke key = terminal.pollInput(); //pollInput is non-blocking
            if(key == null) continue;
            if (key.getKeyType() == KeyType.EOF) { break; }
            if(!processKey(key)); //monsters should only move if player inputs a valid key
            level.moveEnemies();
            level.moveBullets();
        }
    }

    private boolean processKey(KeyStroke key)
    {
        return level.processKey(key);
    }

    private void loadLevel1()
    {
        level = new Level(20,20);
        Player player = new Player(new Position(1,1));
        Dreg dreg = new Dreg(new Position(8,8));
        Dreg dreg2 = new Dreg(new Position(8,5));
        List<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.add(dreg);
        enemyList.add(dreg2);
        List<Wall> wallList = new ArrayList<Wall>();
        for(int i = 0; i < level.getNumRows();i++)
        {
            wallList.add(new Wall(new Position(level.getNumRows()-1,i)));
            wallList.add (new Wall(new Position(0, i)));
        }
        for(int i = 0; i < level.getNumColumns(); i++)
        {
            wallList.add(new Wall(new Position(i,0)));
            wallList.add(new Wall(new Position(i,level.getNumColumns()-1)));
        }
        level.generateEntities(player,enemyList,wallList);
    }
}
