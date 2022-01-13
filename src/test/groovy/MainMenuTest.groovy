import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame
import game.Game
import game.MainMenu
import spock.lang.Specification

import java.awt.Font
import java.awt.GraphicsEnvironment
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

class MainMenuTest extends Specification
{
    private Game game;

    void 'setup'()
    {
        game = new Game();
    }

    def 'Menu Creation'()
    {
        when:
        MainMenu mainMenu = new MainMenu(game)
        then:
        mainMenu.getMessages().size() == 3
        mainMenu.getSelected() == 0
    }

    def 'Menu option selection'()
    {
        given:
        MainMenu mainMenu = new MainMenu(game)
        when:
        mainMenu.previousOption()
        mainMenu.nextOption()
        mainMenu.nextOption()
        then:
        mainMenu.getSelected() == 1
    }
}
