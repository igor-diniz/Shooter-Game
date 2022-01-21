package game;

import game.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application
{
    public static void main(String[] args) throws IOException, InterruptedException, FontFormatException, URISyntaxException {
        Game game = new Game(new LanternaGUI(24,50));
        game.run();
    }
}
