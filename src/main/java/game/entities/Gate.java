package game.entities;

public class Gate extends ImmobileEntity{
    public Gate(Position position) {
        super(position);
    }

    @Override
    protected char generateCharacter() {
        return '_';
    }

    @Override
    protected String generateColor() {
        return "#96281b";
    }

    public void open()
    {
        setCharacter(' ');
    }
}
