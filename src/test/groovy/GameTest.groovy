import game.Game
import game.Level
import game.entities.Player
import game.entities.Position
import game.gui.GUI
import game.state.State
import spock.lang.Specification

class GameTest extends Specification
{
    def 'Game run'()
    {
        given:
        Level level = Mock(Level.class)
        GUI gui = Mock(GUI.class)
        level.isGameOver() >> false >> true
        State state = Mock(State.class)
        Game game = new Game(level,gui,state)
        level.getPlayer() >> new Player(new Position(10,10))
        when:
        game.run()
        then:
        1 * gui.clear();
        2 * state.show(gui);
        1 * gui.refresh();
        1 * gui.pollInput();
        1 * state.processInput(_);
    }
}
