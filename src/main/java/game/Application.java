package game;

import java.io.IOException;

public class Application
{
    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        game.run();
       /* GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font allFonts[] = ge.getAllFonts();
        Vector<String> s = new Vector<String>();
        for (int i = 0; i < allFonts.length ; i++)
        {
            s.add(allFonts[i].getName());
        }
        for (int i = 0; i < s.size() ; i++)
        {
            System.out.println(s.get(i));
        }*/
        /*
        "VL Gothic Regular",
            "NanumGothic",
            "WenQuanYi Zen Hei Mono",
            "WenQuanYi Zen Hei",
            "AR PL UMing TW",
            "AR PL UMing HK",
            "AR PL UMing CN"
         */
    }
}
