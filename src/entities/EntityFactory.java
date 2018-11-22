package src.entities;

import src.entities.collectibles.Coin;
import src.entities.collectibles.Gem;
import src.entities.collectibles.Star;
import src.entities.enemies.Fly;
import src.entities.enemies.Poker;
import src.entities.enemies.Slime;
import src.entities.gameplayobjects.Spikes;
import src.entities.gameplayobjects.SpringBoard;
import src.entities.keys.KeyBlue;
import src.entities.keys.KeyGreen;
import src.entities.keys.KeyRed;
import src.entities.keys.KeyYellow;

public class EntityFactory {
    protected Entity createEntity(EntityType entityType) {
        Entity entity;
        switch (entityType) {
            case BLUEKEY:
                return new KeyBlue();
            case GREENKEY:
                return new KeyGreen();
            case REDKEY:
                return new KeyRed();
            case YELLOWKEY:
                return new KeyYellow();
            case COIN:
                return new Coin();
            case STAR:
                return new Star();
            case YELLOWGEM:
                return new Gem();
            case SPIKES:
                return new Spikes();
            case SPRINGBOARD:
                return new SpringBoard();
            case FLY:
                return new Fly();
            case POKER:
                return new Poker();
            case SLIME:
                return new Slime();
        }
        return new Entity();
    }
}
