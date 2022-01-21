package game.entities

import game.entities.Position
import spock.lang.Specification
class PositionTest extends Specification
{
    def 'Position getters and setters'()
    {
        given:
        Position pos = new Position(10,10)
        when:
        int x = pos.getX()
        int y = pos.getY()
        then:
        x == 10
        y == 10
    }

    def 'Position distance Test'()
    {
        given:
        Position pos = new Position(10,10)
        Position pos2 = new Position(13,14)
        when:
        double distance = pos.distanceTo(pos2)
        then:
        distance == 5
    }

    def 'Position hash test'()
    {
        given:
        Position position = new Position(10,10)
        when:
        int hash = position.hashCode()
        then:
        hash == 1281
    }
}
