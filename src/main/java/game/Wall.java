package game;

public class Wall extends Entity {


    public Wall(Position position)
    {
        super(position);
    }

    @Override
    protected char generateCharacter() {
        return 'W';
    }


}
