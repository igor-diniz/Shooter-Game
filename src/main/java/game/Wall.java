package game;

public class Wall extends Entity {


    public Wall(Position position)
    {
        super(position);
        this.setColor("#4d2f1f");

    }

    @Override
    protected int generateActionDelay() {
        return 0;
    }

    @Override
    protected char generateCharacter() {
        return '#';
    }


}
