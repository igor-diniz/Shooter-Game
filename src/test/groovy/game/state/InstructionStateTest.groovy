package game.state

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import game.Game
import game.gui.LanternaGUI
import spock.lang.Specification

class InstructionStateTest extends Specification
{
    Game game = Mock(Game.class)
    InstructionState instructionState = new InstructionState(game)
    def 'Instruction State Show Test'()
    {
        LanternaGUI gui = Mock(LanternaGUI.class)
        when:
        instructionState.show(gui)
        then:
        1 * gui.drawInstructions()
    }

    def 'Instruction Process Input Test'()
    {
        given:
        KeyStroke key = Stub(KeyStroke)
        key.getKeyType() >> KeyType.Character
        key.getCharacter() >>> ['w','q']
        when:
        instructionState.processInput(key)
        instructionState.processInput(key)
        then:
        1 * game.setState(_)

    }

}
