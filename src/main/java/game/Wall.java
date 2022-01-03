package game;

public class Wall extends Entity {


    public Wall(Position position)
    {
        super(position);
    }

    @Override
    protected int generateActionDelay() {
        return 0;
    }

    @Override
    protected char generateCharacter() {
        return 'w';
    }


}
