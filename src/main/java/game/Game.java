package game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.enemies.*;
import game.entities.Gate;
import game.entities.Player;
import game.entities.Position;
import game.entities.Wall;
import game.gui.GUI;
import game.state.MenuState;
import game.state.State;


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Game
{
    private Level level;
    private final int frameRateInMillis = 30;
    private State state;
    private GUI gui;
    private static int level_number = 1;
    public Game()
    {
        loadLevelFromText();
        state = new MenuState(this);
    } // used for testing purposes

    public Game(GUI gui) throws IOException, FontFormatException, URISyntaxException {
        this.gui = gui;
        loadLevelFromText();
        state = new MenuState(this);

    }


    public Game(Level level,GUI gui,State state) throws URISyntaxException, IOException, FontFormatException {
        this.level = level;
        this.gui = gui;
        this.state = state;
    } //used for testing purposes

    public Level getLevel()
    {
        return level;
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
            if(key != null && key.getKeyType() == KeyType.Character ) state.processInput(key);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            if (sleepTime > 0) Thread.sleep(sleepTime);
        }
        state.show(gui);
        if(level.getPlayer().getHealth() > 0) System.out.println("You won!");
        else System.out.println("You lose!");
    }
    /*
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
        List<Enemy> enemyList = new ArrayList<>();
        enemyList.add(vandal);
        enemyList.add(dreg);
        enemyList.add(dreg2);
        enemyList.add(captain);
        enemyList.add(thrall);
        enemyList.add(thrall1);
        enemyList.add(acolyte);
        enemyList.add(knight);
        List<Wall> wallList = new ArrayList<>();
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
        //level.generateEntities(player,enemyList,wallList, gateList);
    }*/

    public void loadLevelFromText(){
        FileReader file = new FileReader("1_"+ level_number + ".txt");
        level_number++;
        level = new Level(27,50);
        Player player = new Player(new Position(10,10));
        List<String> lines = file.getLevel();
        List<Enemy> enemyList = new ArrayList<>();
        List<Wall> wallList = new ArrayList<>();
        List<Gate> gateList = new ArrayList<>();
        for (int row = 0; row < lines.size() ; row++){
            String line = lines.get(row);
            char[] ch = new char[line.length()];
            for (int i = 0; i < line.length(); i++) ch[i] = line.charAt(i);
            for (int col = 0; col < line.length() ; col++)
                switch (ch[col]) {
                    case 'p' : player = new Player(new Position(col,row)); break;
                    case '#' : wallList.add(new Wall(new Position(col,row))); break;
                    case '_' : gateList.add(new Gate(new Position(col,row))); break;
                    case 'a' : enemyList.add(new Acolyte(new Position(col,row)));break;
                    case 'c' : enemyList.add(new Captain(new Position(col,row)));break;
                    case 'd' : enemyList.add(new Dreg(new Position(col,row))); break;
                    case 'k' : enemyList.add(new Knight(new Position(col,row))); break;
                    case 't' : enemyList.add(new Thrall(new Position(col,row))); break;
                    case 'v' : enemyList.add(new Vandal(new Position(col,row))); break;
                }
        }
        level.generateEntities(player,enemyList,wallList,gateList);
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
