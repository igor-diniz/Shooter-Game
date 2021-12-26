import java.util.ArrayList;
import java.util.List;

public class Player
{
    private int health;
    private List<Weapon> weapons;
    Player(int health)
    {
        this.health = health;
        weapons = new ArrayList<>();
    }
}
