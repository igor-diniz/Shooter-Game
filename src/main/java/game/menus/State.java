package game.menus;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public interface State
{
    void showMenu(TextGraphics graphics);
    void processInput(KeyStroke keystroke);
}
