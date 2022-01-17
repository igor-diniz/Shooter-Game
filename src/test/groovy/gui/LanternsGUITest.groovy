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
}