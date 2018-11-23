package src.entities.CharacterCoin;

import src.Hero;
import src.Main;
import src.entities.Entity;

public class CharacterCoin extends Entity {
    private int heroState;

    public CharacterCoin(int heroState) {
        super();
        switch (heroState) {
            case 1:
            case 2:
            case 3:
                setImage("HUD\\hud_p" + heroState + "Alt.png");
                break;
            default:
                throw new IllegalArgumentException("Invalid heroState\nheroState must be 1, 2 or 3");
        }
        this.heroState = heroState;
    }

    @Override
    public void act() {
        super.act();
        if (Main.debug) return;
        if (getObjectsAtOffset(0, 0, Hero.class).size() != 0) {
            getWorld().removeObject(this);
            Main.worldInstance.hero.setHeroState(heroState);
        }
    }
}
