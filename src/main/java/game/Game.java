package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import game.enemies.*;
import game.gui.GUI;
import game.gui.LanternaGUI;
import game.menus.MenuState;
import game.menus.State;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Game
{
    private Level level;
    private final int frameRateInMillis = 30;
    private State state;
    private GUI gui;
    public Game() throws IOException, FontFormatException, URISyntaxException {
        gui = new LanternaGUI(24,50);
        loadLevel1();
        state = new MenuState(this);
    }

    public Level getLevel()
    {
        return level;
    }

    private void draw() throws IOException {
        gui.clear();
        gui.drawGame(level);
        gui.refresh();
    }

    public void run() throws IOException, InterruptedException {
        int frameTime = 1000 / this.frameRateInMillis;
        while(!level.isGameOver())
        {
            long startTime = System.currentTimeMillis();
            gui.clear();
            state.show(gui);
            gui.refresh();
            KeyStroke key = gui.pollInput();
            state.processInput(key);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            if (sleepTime > 0) Thread.sleep(sleepTime);
        }
        draw();
        if(level.getPlayer().getHealth() > 0) System.out.println("You won!");
        else System.out.println("You lose!");
    }

    private void loadLevel1()
    {
        int HUDSize = 3;
        level = new Level(24,50);
        Player player = new Player(new Position(1,1));
        Dreg dreg = new Dreg(new Position(8,8));
        Dreg dreg2 = new Dreg(new Position(8,5));
        Vandal vandal = new Vandal(new Position (8,2));
        Captain captain = new Captain(new Position(10,5));
        Thrall thrall = new Thrall(new Position(12,8));
        Thrall thrall1 = new Thrall(new Position(15,9));
        Acolyte acolyte = new Acolyte(new Position(14,6));
        Knight knight = new Knight(new Position(13,8));
        List<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.add(vandal);
        enemyList.add(dreg);
        enemyList.add(dreg2);
        enemyList.add(captain);
        enemyList.add(thrall);
        enemyList.add(thrall1);
        enemyList.add(acolyte);
        enemyList.add(knight);
        List<Wall> wallList = new ArrayList<Wall>();
        for(int i = 0; i < level.getNumRows()-HUDSize;i++)
        {
            wallList.add(new Wall(new Position(level.getNumColumns()-1,i)));
            wallList.add (new Wall(new Position(0, i)));
        }
        for(int i = 0; i < level.getNumColumns(); i++)
        {
            wallList.add(new Wall(new Position(i,0)));
            wallList.add(new Wall(new Position(i,level.getNumRows()-HUDSize-1)));
        }
        for(int i = 0; i < level.getNumRows()/2;i++)
        {
            wallList.add(new Wall(new Position(5,i)));
        }
        level.generateEntities(player,enemyList,wallList);
    }

    public GUI getGUI() {
        return gui;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
