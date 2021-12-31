package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game
{
    private Screen screen;
    private Level level;
    private Terminal terminal;
    public Game(Level level) throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal(); //reused from hero ta aqui so pra eu lembrar como se fazem as coisas
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        TerminalSize terminalSize = new TerminalSize(level.getNumColumns(), level.getNumRows());
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
    }

    private void draw() throws IOException {
        screen.clear();
        level.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while(true)
        {
            KeyStroke key = terminal.pollInput(); //pollInput is non-blocking
            if(key == null) continue;
            processKey(key);
        }
    }

    private void processKey(KeyStroke key)
    {
        level.processKey(key);
    }
}
