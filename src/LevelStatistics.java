package src;

import src.worlds.LevelSelecting;

/**
 * @author D. Hout
 */

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
        Main.worldInstance.coinsGained++;
        Main.worldInstance.overlay.updateCoinCount();
    }

    public void addStar() {
        stars++;
        LevelSelecting.getInstance().updateStars();
        LevelSelecting.getInstance().updateUnlockedLevels();
        Main.worldInstance.overlay.addStar();
    }
}
