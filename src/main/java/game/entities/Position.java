package game.entities;


import java.util.Objects;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Position)) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double distanceTo(Position position) {
        return Math.sqrt(Math.pow(this.x - position.x, 2) + Math.pow(this.y - position.y, 2));
    }

}
