package src.worlds;

import src.AbstractWorld;
import src.entities.CharacterCoin.CharacterCoin1;
import src.entities.CharacterCoin.CharacterCoin2;
import src.entities.CharacterCoin.CharacterCoin3;
import src.entities.collectibles.Coin;
import src.entities.collectibles.Star;
import src.entities.enemies.Slime;
import src.entities.keys.KeyBlue;
import src.entities.keys.KeyGreen;
import src.entities.keys.KeyRed;
import src.entities.keys.KeyYellow;

/**
 * @author D. Hout
 *
 */

public class Level1 extends AbstractWorld {

    private static Level1 instance = new Level1();

    private int[][] mapRaw = {
            {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,15,3,3,3,6,-1,-1,-1,-1,-1,-1,102,-1,-1,-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,-1,-1,-1,-1,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,82,65,65,65,65,-1,-1,65,65,65,65,65,-1,-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,82,82,82,82,82,82,-1,6,-1,-1,-1,-1,-1,-1,172,-1,65,65,65,92,92,65,65,65,65,65,92,92,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,65,65,65,82,82,65,-6,-1,-1,-1,89,-1,85,86,172,-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,65,82,82,82,65,65,82,82,82,82,88,82,82,82,82,65,65,-1,-1,-1,98,-1,-1,-1,-1,102,-1,-1,-1,-1,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,88,65,65,65,65,65,65,-1,-1,-1,98,-1,-1,-1,-1,-1,-1,-1,170,-1,65,65,65,65,65,65,65,-1,-1,125,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,88,65,65,65,65,65,65,-1,-1,-1,98,-1,-1,-1,-1,-1,-1,-1,-1,-1,65,65,65,65,65,65,65,83,89,81,65,65,65,15,3,3,15,65,65,65,65,65,65,65,65},
            {65,-1,-1,-1,-1,-1,-1,102,-1,-1,102,-1,-1,-1,-1,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,98,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,97,-1,-1,-1,88,-1,-1,-1,-1,102,-1,-1,102,-1,-1,-1,-1,-1,65,65,65},
            {65,-1,172,172,172,-1,-1,15,2,15,15,-1,-1,-1,-1,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,98,-1,-1,6,3,3,6,3,6,-1,-1,-1,-1,-1,97,-1,-1,-1,-1,-1,-1,-1,-1,104,-1,-1,104,-1,-1,-1,-1,-1,65,65,65},
            {65,168,172,61,172,169,-1,-1,-1,-1,99,-1,-1,-1,-1,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,98,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,97,-1,-1,15,3,15,-1,-1,-1,97,97,97,97,-1,-1,-1,-1,-1,65,65,65},
            {65,-1,172,60,172,-1,-1,-1,-1,-1,99,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,98,0,1,-1,-1,-1,-1,-1,87,84,-1,-1,-1,-1,97,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,65,65,65},
            {78,82,82,82,82,82,82,82,82,82,82,-1,-1,-1,82,82,82,82,82,82,82,82,-1,-1,-1,98,82,82,82,82,82,82,82,82,82,82,-1,-1,-1,82,82,82,82,82,82,82,82,82,-1,-1,-1,-1,82,82,82,89,89,65,65,65},
            {65,65,65,65,65,65,65,65,82,82,82,92,92,92,82,82,65,65,65,65,65,65,92,92,92,92,65,65,65,82,82,82,65,65,65,65,92,92,92,65,65,82,82,82,82,65,65,65,92,92,92,92,65,82,82,88,88,65,65,65},
            {65,65,65,65,65,82,82,65,65,65,65,90,90,90,65,65,65,82,82,82,65,65,90,90,90,90,65,65,65,65,65,82,82,65,65,65,90,90,90,65,82,82,82,82,65,82,82,65,90,90,90,90,65,65,65,88,88,65,65,65},
            {65,82,82,65,65,65,65,65,82,82,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,82,82,82,65,65,65,65,65,65,65,65,65,65,65,65,65,82,82,82,82,65,65,65,65,65,82,82,65,88,88,65,65,65},
            {65,65,82,82,82,65,65,65,65,65,65,65,65,65,65,65,82,82,82,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,65,65,65,65,65,65,65,65,65,65,82,82,82,65,65,65,65,88,88,65,65,65},
            {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,168,-1,-1,82,82,82,96,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,88,88,65,65,65},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,82,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,65,65,65},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,3,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,65,82,82,65,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,65,65,65},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,89,81,82,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,88,88,65,65,65},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,89,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,-1,-1,-1,-1,-1,65,-1,-1,-1,-1,-1,-1,128,-1,-1,-1,-1,-1,-1,-1,-1,89,-1,-1,67,82,65,65,65},
            {-1,-1,-1,-1,-1,15,3,15,-1,-1,-1,88,81,82,83,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,-1,-1,-1,-1,-1,65,-1,-1,-1,81,82,82,82,82,83,-1,-1,-1,-1,6,6,88,-1,-1,-1,-1,65,65,65},
            {-1,59,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,-1,-1,-1,-1,-1,65,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,-1,-1,-1,-1,65,65,65},
            {-1,58,-1,128,86,85,-1,-1,-1,-1,-1,88,-1,-1,-1,-1,-1,-1,-1,-1,62,62,63,62,-1,-1,-1,-1,-1,128,88,-1,-1,84,87,-1,65,0,0,-1,-1,-1,-1,-1,-1,-1,-1,85,87,-1,-1,-1,-1,-1,-1,-1,-1,65,65,65},
            {82,82,82,82,82,82,82,82,17,17,17,82,82,82,82,-1,81,83,-1,82,82,82,82,82,82,-1,-1,82,82,82,82,82,82,82,82,-1,65,82,82,82,82,-1,-1,-1,-1,-1,82,82,82,82,82,82,82,82,82,-1,-1,65,65,65},
            {65,65,65,82,82,82,82,65,95,95,95,65,65,65,65,95,95,95,95,65,82,82,82,65,65,95,95,65,65,82,82,82,82,65,65,65,65,65,65,65,65,95,95,95,95,95,65,65,65,65,65,65,65,65,65,95,95,65,65,65},
            {82,82,65,65,65,65,65,65,93,93,93,65,65,65,65,93,93,93,93,65,65,65,65,65,65,93,93,65,65,65,65,65,65,65,65,82,82,65,65,65,65,93,93,93,93,93,65,65,65,65,65,65,65,65,65,93,93,65,65,65},
    };

    private Level1() {
        super(90, 1740);
        this.map = mapRaw;
    }

    public static Level1 getInstance() {
        return instance;
    }

    @Override
    public void loadWorld() {
        super.loadWorld();
        addEntity(new Slime(), 1296, 1719);
        addEntity(new Coin(), 630, 1710);
        addEntity(new Coin(), 510, 1710);
        addEntity(new Coin(), 570, 1710);
        addEntity(new Coin(), 990, 1590);
        addEntity(new Coin(), 990, 1650);
        addEntity(new Star(), 2130, 1770);
        addEntity(new CharacterCoin3(), 1950, 1350);
        addEntity(new KeyBlue(), 2250, 1230);
        addEntity(new Coin(), 2250, 1350);
        addEntity(new Coin(), 2250, 1410);
        addEntity(new Coin(), 2250, 1470);
        addEntity(new Coin(), 2250, 1530);
        addEntity(new CharacterCoin1(), 3224, 1639);
        addEntity(new Coin(), 3390, 930);
        addEntity(new Coin(), 3330, 930);
        addEntity(new KeyGreen(), 3090, 450);
        addEntity(new Coin(), 3030, 450);
        addEntity(new Coin(), 2970, 450);
        addEntity(new Coin(), 2910, 450);
        addEntity(new CharacterCoin3(), 2550, 630);
        addEntity(new CharacterCoin1(), 2550, 930);
        addEntity(new KeyRed(), 1830, 630);
        addEntity(new CharacterCoin3(), 870, 510);
        addEntity(new CharacterCoin2(), 330, 330);
        addEntity(new Star(), 1230, 510);
        addEntity(new KeyYellow(), 1770, 270);
        addEntity(new CharacterCoin1(), 1230, 450);
    }
    @Override
    public void reset() {
        instance = new Level1();
        instance.loadWorld();
    }
}
