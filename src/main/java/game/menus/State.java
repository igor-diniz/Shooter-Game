package game.menus;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import game.gui.GUI;

public interface State
{
    void show(GUI gui);
    void processInput(KeyStroke keystroke);
}
