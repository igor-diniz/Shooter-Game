import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame
import game.MainMenu
import spock.lang.Specification

import java.awt.Font
import java.awt.GraphicsEnvironment
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

class MainMenuTest extends Specification
{
    private Screen screen;

    void 'setup'()
    {
        URL resource = getClass().getClassLoader().getResource("fate.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN,45);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        TerminalSize terminalSize = new TerminalSize(16, 16);
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).setForceAWTOverSwing(true)
                .setTerminalEmulatorFontConfiguration(fontConfig).createTerminal();
        ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    def 'Menu Creation'()
    {
        given:
        MainMenu mainMenu = new MainMenu(screen)
        then:
        mainMenu.getMessages().size() == 3
        mainMenu.getSelected() == 1
    }

    def 'Menu option selection'()
    {
        given:
        MainMenu mainMenu = new MainMenu(screen)
        when:
        mainMenu.previousOption()
        mainMenu.nextOption()
        mainMenu.nextOption()
        then:
        mainMenu.getSelected() == 2
    }
}
