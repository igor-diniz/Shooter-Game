package game.state.command

import game.Game
import spock.lang.Specification

class InstructionCommandTest extends Specification
{
    def 'Instruction Command Creation Test'()
    {
        Game game = Mock(Game.class)
        when:
        InstructionCommand instructionCommand = new InstructionCommand(game)
        then:
        instructionCommand.getText() == "INSTRUCTIONS"
    }

    def 'Instruction Command Operations Test'()
    {
        given:
        Game game = Mock(Game.class)
        InstructionCommand instructionCommand = new InstructionCommand(game)
        when:
        instructionCommand.execute()
        instructionCommand.undo()
        then:
        2 * game.setState(_)
        1 * game.getState()
    }
}
