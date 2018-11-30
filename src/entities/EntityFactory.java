package src.entities;

import src.AbstractWorld;
import src.entities.CharacterCoin.CharacterCoin1;
import src.entities.CharacterCoin.CharacterCoin2;
import src.entities.CharacterCoin.CharacterCoin3;
import src.entities.collectibles.Coin;
import src.entities.collectibles.Gem;
import src.entities.collectibles.Star;
import src.entities.enemies.FireBall;
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

    public static Entity createEntity(EntityType entityType) {

        Entity entity;

        switch (entityType) {
            case KEY_BLUE:
                entity = new KeyBlue();
                entity.constructor = "new KeyBlue()";
                break;
            case KEY_GREEN:
                entity = new KeyGreen();
                entity.constructor = "new KeyGreen()";
                break;
            case KEY_RED:
                entity = new KeyRed();
                entity.constructor = "new KeyRed()";
                break;
            case KEY_YELLOW:
                entity = new KeyYellow();
                entity.constructor = "new KeyYellow()";
                break;
            case COIN:
                entity = new Coin();
                entity.constructor = "new Coin()";
                break;
            case CHARACTER_COIN_1:
                entity = new CharacterCoin1();
                entity.constructor = "new CharacterCoin1()";
                break;
            case CHARACTER_COIN_2:
                entity = new CharacterCoin2();
                entity.constructor = "new CharacterCoin2()";
                break;
            case CHARACTER_COIN_3:
                entity = new CharacterCoin3();
                entity.constructor = "new CharacterCoin3()";
                break;
            case STAR:
                entity = new Star();
                entity.constructor = "new Star()";
                break;
            case GEM:
                entity = new Gem();
                entity.constructor = "new Gem()";
                break;
            case SPIKES:
                entity = new Spikes();
                entity.constructor = "new Spikes()";
                break;
            case SPRINGBOARD:
                entity = new SpringBoard();
                entity.constructor = "new SpringBoard()";
                break;
            case FLY:
                entity = new Fly();
                entity.constructor = "new Fly()";
                break;
            case POKER:
                entity = new Poker();
                entity.constructor = "new Fly()";
                break;
            case SLIME:
                entity = new Slime();
                entity.constructor = "new Slime()";
                break;
            case FIREBALL:
                entity = new FireBall();
                entity.constructor = "new FireBall()";
                break;
            default:
                entity = new Entity();
                break;
        }
        return entity;
    }
}
