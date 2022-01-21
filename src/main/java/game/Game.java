package game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.enemies.*;
import game.entities.Player;
import game.entities.Position;
import game.entities.Wall;
import game.gui.GUI;
import game.gui.LanternaGUI;
import game.state.MenuState;
import game.state.State;
import sun.nio.cs.US_ASCII;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game
{
    private Level level;
    private final int frameRateInMillis = 30;
    private State state;
    private GUI gui;
    int levelCounter = 0;
    public Game() throws FileNotFoundException {
        loadLevelFromFile();
        state = new MenuState(this);
    } // used for testing purposes

    public Game(GUI gui) throws IOException, FontFormatException, URISyntaxException {
        this.gui = gui;
        loadLevelFromFile();
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

    public void run() throws IOException, InterruptedException, URISyntaxException, FontFormatException {
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
    }

    public void loadLevelFromFile() throws FileNotFoundException {
        String theString;

        levelCounter++;
        if(levelCounter == 6) System.exit(0);
        File file = new File("src/main/resources/"+levelCounter+".txt");
        Scanner scanner = new Scanner(file, Charset.defaultCharset().name());

        theString = scanner.nextLine();
        while (scanner.hasNextLine()) {
            theString = theString + scanner.nextLine();
        }
        char[] charArray = theString.toCharArray();

        List<Enemy> enemyList = new ArrayList<Enemy>();
        List<Wall> wallList = new ArrayList<Wall>();
        Player player = new Player(new Position(10,10));

        level = new Level(24, 50);
        for (int row = 0; row < level.getNumRows() - 3; row++) {
            for (int col = 0; col < level.getNumColumns(); col++) {
                switch (charArray[col + row * level.getNumColumns()]) {
                    case 'p': player = new Player(new Position(col, row));break;
                    case '#': wallList.add(new Wall(new Position(col, row)));break;
                    case 'a': enemyList.add(new Acolyte(new Position(col, row)));break;
                    case 'c': enemyList.add(new Captain(new Position(col, row)));break;
                    case 'd': enemyList.add(new Dreg(new Position(col, row)));break;
                    case 'k': enemyList.add(new Knight(new Position(col, row)));break;
                    case 't': enemyList.add(new Thrall(new Position(col, row)));break;
                    case 'v': enemyList.add(new Vandal(new Position(col, row)));break;
                }
            }
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
