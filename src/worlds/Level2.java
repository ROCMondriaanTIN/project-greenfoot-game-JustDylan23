package src.worlds;

import src.AbstractWorld;
import src.entities.CharacterCoin.CharacterCoin1;
import src.entities.CharacterCoin.CharacterCoin2;
import src.entities.CharacterCoin.CharacterCoin3;
import src.entities.collectibles.Coin;
import src.entities.collectibles.Star;
import src.entities.enemies.FireBall;
import src.entities.enemies.Fly;
import src.entities.enemies.Slime;
import src.entities.gameplayobjects.MovingPlatform;
import src.entities.keys.KeyBlue;
import src.entities.keys.KeyGreen;
import src.entities.keys.KeyRed;
import src.entities.keys.KeyYellow;

public class Level2 extends AbstractWorld {

    public Level2() {
        super(60, 180);
        setBackground("bg_castle.png");
        this.map = new int[][]{
                {19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19},
                {-1, -1, 15, 3, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 102, -1, -1, -1, 102, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, -1, -1, -1, -1, 19, -1, 98, 98, 98, 98, 98, 98, -1, -1, -1, -1, 19, 19},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 104, -1, -1, -1, 104, 168, 19, 19, 19, 19, 19, 19, 19, 89, -1, -1, -1, -1, -1, 19, 169, -1, -1, -1, -1, -1, 168, 19, 36, 36, 36, 36, 36, 98, -1, -1, -1, -1, 168, 19, 19},
                {128, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 104, -1, -1, -1, 104, -1, 19, 19, 19, 19, 19, 19, 19, 88, 36, 36, 36, 36, -1, -1, -1, 36, 36, 36, 36, 36, -1, 19, 19, 19, 19, 19, 19, 19, -1, -1, 36, 36, -1, 19, 19},
                {26, 27, 27, 27, 27, 27, 28, -1, -1, 26, 27, 27, 27, 27, 27, 28, -1, -1, 36, 36, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 88, 19, 19, 19, 19, 36, 36, 36, 19, -1, -1, -1, 19, -1, 19, 19, 19, 19, 19, 19, -1, -1, 36, 19, 19, -1, 19, 19},
                {92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 19, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 88, 19, -1, -1, -1, 102, -1, -1, -1, -1, -1, -1, 102, -1, 19, 19, 19, 19, 19, -1, -1, 36, 19, 19, 19, -1, 19, 19},
                {90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 19, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 88, 19, -1, -1, -1, 36, 36, 36, 36, 36, 92, 36, 36, 36, 19, 19, 19, 19, -1, -1, 36, 19, 19, 19, 19, -1, 19, 19},
                {19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 88, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, 36, 19, 19, 19, 19, 19, -1, 19, 19},
                {19, -1, -1, -1, -1, 102, -1, 102, -1, -1, -1, 102, 3, 102, -1, -1, -1, -1, -1, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 88, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, 19, 19, 19, -1, -1, 36, 19, 19, 19, 19, 19, 19, -1, 19, 19},
                {19, -1, -1, 168, -1, 104, -1, 104, -1, -1, -1, 104, -1, 104, -1, -1, 169, -1, -1, 98, -1, -1, -1, -1, -1, 169, -1, -1, -1, -1, -1, -1, 88, 98, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, 19, 19, -1, -1, 36, 19, 19, 19, 19, 19, 19, 19, -1, 19, 19},
                {19, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, 104, -1, 104, -1, -1, -1, -1, -1, 98, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, 98, -1, -1, -1, -1, -1, -1, 36, 36, 36, -1, -1, -1, -1, -1, 98, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, -1, -1, 98, -1, -1, -1, -1, -1, -1, 128, -1, -1, -1, -1, -1, -1, 98, -1, -1, -1, 36, 36, 36, 19, 19, 19, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 19, 19},
                {19, -1, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, 89, 26, 27, 36, 99, 99, 99, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19},
                {19, -1, 26, 27, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, -1, -1, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19},
                {19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, 88, -1, -1, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 96, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, -1, -1, -1, -1, 88, -1, -1, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 96, -1, -1, -1, -1, -1, -1, 169, -1, 19, 19},
                {19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 96, -1, -1, 127, -1, -1, -1, -1, -1, 19, 19},
                {19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, 89, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, 36, 36, 36, 36, 36, 37, -1, -1, 19, 19},
                {19, 89, -1, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, -1, -1, 19, -1, -1, -1, -1, 89, -1, -1, 88, -1, -1, -1, 89, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 88, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 92, 92, 19, -1, 128, -1, -1, 88, -1, -1, -1, -1, -1, -1, 88, -1, -1, 89, -1, -1, -1, 36, 36, 36, 36, 36, 36, 36, 36, -1, -1, -1, 19, -1, 171, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 88, -1, 19, -1, -1, -1, 168, -1, -1, -1, -1, -1, 169, -1, 89, 19, 90, 90, 19, 36, 36, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 88, -1, 19, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, -1, 88, 19, 90, 90, 19, 19, 19, 19, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 19, -1, -1, -1, -1, -1, -1, 96, -1, -1, -1, 19, -1, -1, 35, 36, 36, 36, 36, 36, 19, 19},
                {19, 88, -1, -1, -1, -1, -1, -1, -1, 19, 15, 3, 15, 19, -1, 88, 19, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 19, 36, 36, 36, 36, 36, 36, 36, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 88, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, 168, -1, 19, 19},
                {19, 88, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 88, -1, -1, -1, -1, -1, -1, -1, 36, 36, 36, 36, 36, 36, 36, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 89, 19, 19, 19, -1, -1, -1, 19, 36, 36, 36, 36, 36, 37, -1, -1, 19, 19},
                {19, 88, -1, -1, -1, 26, 27, 28, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 88, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 88, -1, -1, -1, -1, -1, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 88, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 92, 92, 92, 92, 92, 92, 92, 92, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19, 19, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 90, 90, 90, 90, 90, 90, 90, 90, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19, 19, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, 19, 19, 19, -1, -1, -1, 19, -1, -1, 35, 36, 36, 36, 36, 36, 19, 19},
                {19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, 36, 36, 36, 36, 36, 36, 36, -1, -1, 36, 36, 19, 19, 19, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, 19, 19, 19, 19, 19, 19, 19, 92, 92, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, 169, -1, 19, 19},
                {19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19, -1, -1, -1, 19, 19, 90, 90, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19, -1, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 96, -1, -1, -1, 19, 36, 36, 36, 36, 36, 37, -1, -1, 19, 19},
                {19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 96, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, -1, -1, 36, 36, 36, 36, 36, 36, -1, -1, 36, 36, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 96, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 19},
                {19, -1, -1, 19, 19, 19, 19, 19, 19, 92, 92, 19, 19, 19, 19, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 19, 19},
                {19, -1, -1, 19, 19, 19, 19, 19, 19, 90, 90, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19},
                {19, -1, -1, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, -1, 97, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, 102, -1, -1, -1, -1, 102, -1, -1, -1, -1, 102, -1, -1, -1, 102, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 97, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, 104, -1, -1, -1, -1, 104, -1, -1, -1, -1, 104, -1, -1, -1, 104, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 97, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, 25, -1, -1, -1, 104, -1, -1, -1, -1, 104, -1, -1, -1, -1, 104, -1, -1, -1, 104, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, 36, 36, -1, -1, 36, -1, -1, -1, 36, -1, -1, 36, 36, 37, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, 104, -1, -1, -1, -1, 104, -1, -1, -1, -1, 104, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, 26, 28, -1, -1, -1, -1, 19, 92, 92, 19, -1, -1, -1, 19, 92, 92, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 27, 27, 27, 28, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, 26, 28, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 90, 19, -1, -1, -1, 19, 90, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, 89, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 19, 19, -1, -1, -1, 19, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, 88, 26, 27, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, 88, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, 88, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, -1, 89, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, -1, 26, 27, 28, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 88, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, 19, -1, 172, 172, 172, -1, 19, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, -1, -1, 172, 61, 172, -1, -1, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, -1, -1, 128, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 90, -1, -1, 172, 60, 172, -1, -1, 90, 19, -1, -1, -1, -1, -1, -1, -1},
                {19, 36, 36, 36, 36, 36, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 19, 90, 92, 92, 36, 36, 36, 92, 92, 90, 19, 92, 92, 92, 92, 92, 92, 92},
                {19, 19, 19, 19, 19, 19, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90},
                {19, 19, 19, 19, 19, 19, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90},
                {19, 19, 19, 19, 19, 19, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90}
            };
    }

    @Override
    public void loadWorld() {
        addEntity(new Star(4), 2850, 90);
        addEntity(new Slime(), 810, 210);
        addEntity(new Coin(), 1410, 210);
        addEntity(new Coin(), 1470, 210);
        addEntity(new Fly(), 1290, 450);
        addEntity(new MovingPlatform(8), 1290, 750);
        addEntity(new CharacterCoin3(), 1950, 150);
        addEntity(new Fly(), 2310, 150);
        addEntity(new Coin(), 2490, 570);
        addEntity(new Coin(), 2430, 570);
        addEntity(new Coin(), 2550, 570);
        addEntity(new KeyRed(), 3450, 90);
        addEntity(new Coin(), 2910, 630);
        addEntity(new Coin(), 3390, 630);
        addEntity(new Coin(), 3270, 630);
        addEntity(new Coin(), 3150, 630);
        addEntity(new Coin(), 3030, 630);
        addEntity(new Coin(), 3030, 450);
        addEntity(new Coin(), 3150, 330);
        addEntity(new Coin(), 3450, 570);
        addEntity(new Coin(), 3450, 330);
        addEntity(new Coin(), 3450, 450);
        addEntity(new Coin(), 3450, 210);
        addEntity(new CharacterCoin1(), 1170, 690);
        addEntity(new Coin(), 390, 570);
        addEntity(new Coin(), 210, 750);
        addEntity(new Coin(), 810, 810);
        addEntity(new Coin(), 450, 870);
        addEntity(new KeyYellow(), 330, 1230);
        addEntity(new Coin(), 450, 1530);
        addEntity(new Coin(), 330, 1530);
        addEntity(new Slime(), 653, 1024);
        addEntity(new CharacterCoin3(), 1230, 1170);
        addEntity(new Coin(), 1470, 1110);
        addEntity(new Coin(), 2370, 1110);
        addEntity(new Coin(), 1890, 1110);
        addEntity(new Coin(), 1650, 1050);
        addEntity(new CharacterCoin1(), 2070, 1170);
        addEntity(new MovingPlatform(17), 2850, 2190);
        addEntity(new MovingPlatform(), 3090, 1950);
        addEntity(new MovingPlatform(), 3390, 1710);
        addEntity(new MovingPlatform(), 3030, 1470);
        addEntity(new Fly(), 3270, 1470);
        addEntity(new Fly(), 3090, 1770);
        addEntity(new CharacterCoin2(), 3090, 2130);
        addEntity(new FireBall(), 3270, 1230);
        addEntity(new MovingPlatform(), 3390, 1230);
        addEntity(new KeyBlue(), 3090, 990);
        addEntity(new Fly(), 2850, 1650);
        addEntity(new Star(5), 2370, 1290);
        addEntity(new Fly(), 990, 2010);
        addEntity(new CharacterCoin3(), 990, 2010);
        addEntity(new Coin(), 1590, 2130);
        addEntity(new Coin(), 1470, 2130);
        addEntity(new Coin(), 1350, 2130);
        addEntity(new MovingPlatform(5), 1830, 2190);
        addEntity(new FireBall(), 2190, 2070);
        addEntity(new Fly(), 2070, 2130);
        addEntity(new Coin(), 2310, 2130);
        addEntity(new Coin(), 2430, 2130);
        addEntity(new CharacterCoin1(), 3090, 990);
        addEntity(new Coin(), 2370, 1530);
        addEntity(new Coin(), 2070, 1530);
        addEntity(new Coin(), 1770, 1530);
        addEntity(new Coin(), 1470, 1530);
        addEntity(new Slime(), 971, 1715);
        addEntity(new Fly(), 690, 1830);
        addEntity(new Slime(), 330, 2070);
        addEntity(new Coin(), 570, 3210);
        addEntity(new Coin(), 870, 3090);
        addEntity(new Coin(), 1590, 3270);
        addEntity(new Coin(), 2310, 2910);
        addEntity(new Coin(), 1170, 2910);
        addEntity(new KeyGreen(), 630, 2430);
        addEntity(new Coin(), 1470, 2550);
        addEntity(new Slime(), 957, 2485);
        addEntity(new Coin(), 2850, 3030);
        addEntity(new Coin(), 2850, 2850);
        addEntity(new Coin(), 2850, 2730);
        addEntity(new Coin(), 2850, 2610);
        addEntity(new Coin(), 2850, 2490);
        addEntity(new CharacterCoin1(), 330, 3330);



        super.loadWorld();
    }
}
