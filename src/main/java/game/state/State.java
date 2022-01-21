package game.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import game.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface State
{
    void show(GUI gui);
    void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException;
}
