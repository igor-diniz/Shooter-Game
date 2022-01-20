package game.entities;

public abstract class Entity {
    private Position position;
    private char character;
    private final String color;

    protected Entity(Position position)
    {
        this.position = position;
        character = generateCharacter();
        color = generateColor();
    }

    public void setCharacter(char character){this.character = character;}

    protected abstract char generateCharacter();

    protected abstract String generateColor();

    public char getCharacter() {return character;}

    public Position getPosition() { return position;}

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public String getColor() {
        return color;
    }
}
