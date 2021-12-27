package game;


import com.googlecode.lanterna.screen.Screen;



public class Game
{
    private final int NUM_ROWS;
    private final int NUM_COLUMNS;
    private Player player;
    private char level[][];
    private Screen screen;
    public Game(int numRows,int numColumns)
    {
        NUM_ROWS = numRows;
        player = new Player(new Position(10,10));
        NUM_COLUMNS = numColumns;
        level = new char[NUM_ROWS][NUM_COLUMNS];
        for(int i = 0; i< NUM_ROWS; i++)
        {
            for(int j = 0; j< NUM_COLUMNS; j++)
            {
                level[i][j] = 'x';
            }
        }
    }

    public int getNumRows()
    {
        return NUM_ROWS;
    }

    public int getNumColumns()
    {
        return NUM_COLUMNS;
    }

    public char getCharacterAt(int row,int column)
    {
        return level[row][column];
    }
}
