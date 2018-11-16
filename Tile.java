
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Tile extends Actor {

    public boolean isSolid = false;
    private static int id;
    public int _id;
    public String type;

    public Tile() {
        super();
        if (CollisionEngine.DEBUG) {
            getImage().drawString("ÏD: " + id, 10, 10);
        }
        _id = id;
        id++;
    }

    @Override
    public String toString() {
        return "id: " + _id + "\n"
                + "X: " + getX() + "\n"
                + "Y: " + getY();
    }

    public void setTileImage(String texture) {
        type = texture;
        setImage("Tiles\\" + texture + ".png");
        getImage().scale(TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
    }

    public void setTileImage(String texture, int width, int height) {
        type = texture;
        setImage("Tiles\\" + texture + ".png");
        getImage().scale(width, height);
    }

    public void setTileImage(String texture, boolean flip) {
        type = texture;
        setImage("Tiles\\" + texture + ".png");
        if (flip) {
            getImage().mirrorVertically();
        } else getImage().mirrorHorizontally();
        getImage().scale(TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);

    }

    public void delete() {
        type = "air";
        getImage().clear();
    }
}
