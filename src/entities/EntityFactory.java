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
                break;
            case KEY_GREEN:
                entity = new KeyGreen();
                break;
            case KEY_RED:
                entity = new KeyRed();
                break;
            case KEY_YELLOW:
                entity = new KeyYellow();
                break;
            case COIN:
                entity = new Coin();
                break;
            case STAR:
                entity = new Star();
                break;
            case GEM:
                entity = new Gem();
                break;
            case SPIKES:
                entity = new Spikes();
                break;
            case SPRINGBOARD:
                entity = new SpringBoard();
                break;
            case FLY:
                entity = new Fly();
                break;
            case POKER:
                entity = new Poker();
                break;
            case SLIME:
                entity = new Slime();
                break;
            default:
                entity = new Entity();
                break;
        }
        entity.setWorldInstance(worldInstance);
        return entity;
    }
}
