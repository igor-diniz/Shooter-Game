package gui

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.TerminalScreen
import game.Game
import game.Level
import game.Position
import game.gui.LanternaGUI
import game.menus.Command
import game.menus.ExitCommand
import game.menus.InstructionCommand
import game.menus.PlayCommand
import spock.lang.Specification

class LanternaGUITest extends Specification {

    LanternaGUI gui
    TextGraphics tg
    Position position
    String color

    void 'setup'() {
        position = new Position(10, 10)
        color = "#000000"
        tg = Mock(TextGraphics.class);
        TerminalScreen screen = Mock(TerminalScreen.class);
        gui = new LanternaGUI(screen)
        screen.newTextGraphics() >> tg
    }
    def 'Draw Rectangle Test'()
    {
        when:
        gui.drawRectangle(tg,color,20,50,position)
        then:
        1 * tg.setBackgroundColor(TextColor.Factory.fromString(color))
        1 * tg.fillRectangle(_)
    }

    def 'Fill Background Test'()
    {
        when:
        gui.fillBackground(tg,color)
        then:
        1 * tg.setBackgroundColor(TextColor.Factory.fromString(color))
        1 * tg.fillRectangle(_)
    }

    def 'getWidth Test'()
    {
        when:
        int res = gui.getWidth()
        then:
        res == 20
    }

    def 'getHeight Test'()
    {
        when:
        int res = gui.getHeight()
        then:
        res == 60
    }

    def 'Draw Immobile Entity Test'()
    {
        when:
        gui.drawImmobileEntity(position,color,'#' as char)
        then:
        1 * tg.setForegroundColor(TextColor.Factory.fromString(color))
        1 * tg.putString(new TerminalPosition(position.getX(), position.getY()), String.valueOf('#'));
    }

    def 'Draw Moving Entity Test'()
    {
        when:
        gui.drawMovingEntity(position,color,'p',10)
        gui.drawMovingEntity(position,color,'p',0)
        then:
        2 * tg.setForegroundColor(TextColor.Factory.fromString(color))
        1 * tg.setForegroundColor(TextColor.Factory.fromString("#ff0000"))
        2 * tg.putString(new TerminalPosition(position.getX(), position.getY()), String.valueOf('p'))
    }

    def 'Draw Menu Test'()
    {
        given:
        Game game = new Game()
        List<Command> commandsList = new ArrayList<Command>();
        commandsList.add(new PlayCommand(game));
        commandsList.add(new InstructionCommand(game));
        commandsList.add(new ExitCommand(game));
        int selected = 0
        when:
        gui.drawMenu(game,selected,commandsList)
        then:
        7 * tg.putString(_)
    }

    def 'Draw Inventory Test'()
    {
        given:
        Game game = new Game()
        int selected = 0
        when:
        gui.drawInventory(game,selected)
        then:
        13 * tg.putString(_)
    }

    def 'Draw GameState Test'()
    {
        given:
        Level level = new Level(20,50)
        when:
        gui.drawGame(level)
        then:
        1 * tg.setBackgroundColor(TextColor.Factory.fromString("#000000"))
        1 * tg.fillRectangle(_)
        3 * tg.putString(_)
        gui.drawRectangle()
    }
}