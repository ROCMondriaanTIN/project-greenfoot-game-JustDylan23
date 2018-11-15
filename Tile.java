
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
}
