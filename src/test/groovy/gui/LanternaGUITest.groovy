package gui

import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.TerminalScreen
import game.entities.Bullet
import game.Game
import game.Level
import game.entities.Player
import game.entities.Position
import game.entities.Wall
import game.enemies.Enemy
import game.gui.LanternaGUI
import game.menus.command.Command
import game.menus.command.ExitCommand
import game.menus.command.InstructionCommand
import game.menus.command.PlayCommand
import game.weapons.HandCannon
import spock.lang.Specification

class LanternaGUITest extends Specification {

    LanternaGUI gui
    TextGraphics tg
    Position position
    String color
    TerminalScreen screen

    void 'setup'() {
        position = new Position(10, 10)
        color = "#000000"
        tg = Mock(TextGraphics.class);
        screen = Mock(TerminalScreen.class);
        gui = new LanternaGUI(screen)
        screen.newTextGraphics() >> tg
    }
    def 'Draw Rectangle Test'()
    {
        when:
        gui.drawRectangle(tg,color,20,50,position)
        then:
        1 * tg.setBackgroundColor(TextColor.Factory.fromString(color))
        1 * tg.fillRectangle(_,_,_)
    }

    def 'Fill Background Test'()
    {
        when:
        gui.fillBackground(tg,color)
        then:
        1 * tg.setBackgroundColor(TextColor.Factory.fromString(color))
        1 * tg.fillRectangle(_,_,_)
    }

    def 'getWidth Test'()
    {
        when:
        int res = gui.getWidth()
        then:
        res == 10
    }

    def 'getHeight Test'()
    {
        when:
        int res = gui.getHeight()
        then:
        res == 10
    }

    def 'Draw Immobile Entity Test'()
    {
        given:
        Wall wall = new Wall(position)
        when:
        gui.drawImmobileEntity(wall)
        then:
        1 * tg.setForegroundColor(_)
        1 * tg.putString(new TerminalPosition(position.getX(), position.getY()), String.valueOf('#'))
    }

    def 'Draw Moving Entity Test'()
    {
        given:
        Player player = new Player(position)
        player.takeDamage(3)
        Player player1 = new Player(position)
        when:
        gui.drawMovingEntity(player)
        gui.drawMovingEntity(player1)
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
        7 * tg.putString(_,_,_)
    }

    def 'Draw Inventory Test'()
    {
        given:
        Game game = new Game()
        int selected = 0
        when:
        gui.drawInventory(game,selected)
        then:
        13 * tg.putString(_,_,_)
    }

    def 'Draw GameState Test'()
    {
        given:
        Level level = new Level(20,50)
        level.generateEntities(new Player(position),new ArrayList<Enemy>(),new ArrayList<Wall>())
        when:
        gui.drawGame(level)
        then:
        1 * tg.setBackgroundColor(TextColor.Factory.fromString("#000000"))
        2 * tg.fillRectangle(_,_,_)
        4 * tg.putString(_,_)
    }

    def 'Generic screen tests'()
    {
        when:
        gui.clear()
        gui.pollInput()
        gui.refresh()
        gui.close()
        then:
        1 * screen.pollInput()
        1 * screen.refresh()
        1 * screen.close()
        1 * screen.clear()
    }

    def 'Draw Bullet Test'()
    {
        given:
        Bullet bullet = new Bullet(position,new HandCannon(),'N' as char,true)
        when:
        gui.drawBullet(bullet)
        then:
        1 * tg.setBackgroundColor(TextColor.Factory.fromString("#567D46"))
        1 * tg.setForegroundColor(_)
        1 * tg.enableModifiers(SGR.BOLD)
        1 * tg.disableModifiers(SGR.BOLD)
        1 * tg.putString(_,_)
    }
}