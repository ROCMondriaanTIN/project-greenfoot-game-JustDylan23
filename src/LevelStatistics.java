package src;

import src.worlds.LevelSelecting;

import static src.Main.worldInstance;

public class LevelStatistics {
    private static final LevelStatistics instance = new LevelStatistics();
    public int coins;
    public int stars;

    public static LevelStatistics getInstance() {
        return instance;
    }

    public void addCoin() {
        coins++;
        worldInstance.coinsGained++;
        worldInstance.overlay.updateCoinCount();
    }

    public void addStar() {
        stars++;
        LevelSelecting.getInstance().updateStars();
    }
}
