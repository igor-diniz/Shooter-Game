package game.weapons;

import game.Weapon;

public class RocketLauncher extends Weapon {
    protected RocketLauncher(int damage, int range) {
        super(damage, range);
    }
    private int xAoE; //AoE stands for Area of Effect
    private int yAoE;

    @Override
    public void shoot() {

    }
}
