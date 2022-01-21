package game.gui

import spock.lang.Specification

class LanternaGUICreationTest extends Specification{
    def 'Lanterna GUI creation'()
    {
        when:
        LanternaGUI lanternaGUI = new LanternaGUI(10,10)
        then:
        lanternaGUI.getWidth() == 10
        lanternaGUI.getHeight() == 10
    }
}
