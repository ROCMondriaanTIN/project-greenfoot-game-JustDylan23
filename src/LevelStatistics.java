package src;

import src.worlds.LevelSelecting;

import static src.Main.worldInstance;

public class LevelStatistics {
    private static final LevelStatistics instance = new LevelStatistics();
    int coins;
    public int stars;

    private LevelStatistics() {
    }

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
        LevelSelecting.getInstance().updateUnlockedLevels();
        worldInstance.overlay.addStar();
    }
}
