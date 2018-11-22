package src.entities;

import src.AbstractWorld;
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

    public static Entity createEntity(EntityType entityType, AbstractWorld worldInstance) {

        Entity entity;

        switch (entityType) {
            case KEY_BLUE:
                entity = new KeyBlue();
                entity.constructor = "KEY_BLUE";
                break;
            case KEY_GREEN:
                entity = new KeyGreen();
                entity.constructor = "KEY_GREEN";
                break;
            case KEY_RED:
                entity = new KeyRed();
                entity.constructor = "KEY_RED";
                break;
            case KEY_YELLOW:
                entity = new KeyYellow();
                entity.constructor = "KEY_YELLOW";
                break;
            case COIN:
                entity = new Coin();
                entity.constructor = "COIN";
                break;
            case STAR:
                entity = new Star();
                entity.constructor = "STAR";
                break;
            case GEM:
                entity = new Gem();
                entity.constructor = "GEM";
                break;
            case SPIKES:
                entity = new Spikes();
                entity.constructor = "SPIKES";
                break;
            case SPRINGBOARD:
                entity = new SpringBoard();
                entity.constructor = "SPRINGBOARD";
                break;
            case FLY:
                entity = new Fly();
                entity.constructor = "FLY";
                break;
            case POKER:
                entity = new Poker();
                entity.constructor = "POKER";
                break;
            case SLIME:
                entity = new Slime();
                entity.constructor = "SLIME";
                break;
            default:
                entity = new Entity();
                break;
        }
        entity.setWorldInstance(worldInstance);
        return entity;
    }
}
