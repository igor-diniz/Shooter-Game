package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader{
    private List<String> lines;

    public FileReader(String level) {
        try {
            lines = new ArrayList<>();
            URL resource = getClass().getClassLoader().getResource(level);
            assert resource != null;
            File myObj = new File(resource.toURI());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public List<String> getLevel()  {
        return lines;
    }
}