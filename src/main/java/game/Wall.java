package game;

public class Wall extends ImmobileEntity {


    public Wall(Position position)
    {
        super(position);
    }
    @Override
    protected char generateCharacter() {
        return '#';
    }

    @Override
    protected String generateColor() {
        return "#96281b";
    }

}
