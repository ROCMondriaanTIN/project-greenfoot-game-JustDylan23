package src;

import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class BasicTile extends Actor {

    public boolean isSolid = false;
    public int _id;

    protected static int id;

    protected TileType type = TileType.DEFAULT;
    protected int mapIcon = -1;
    protected int mapID = -1;
    private int colom = -1;
    protected int row = -1;


    public BasicTile() {
        super();
        if (CollisionEngine.DEBUG) {
            getImage().drawString("ID: " + id, 10, 10);
        }
        _id = id;
        id++;
    }

    @Override
    public String toString() {
        return "id: " + _id + "\n"
                + "X: " + getX() + "\n"
                + "Y: " + getY() + "\n"
                + "Type: " + getType();
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public int getMapIcon() {
        return mapIcon;
    }

    public void setMapIcon(int mapIcon) {
        this.mapIcon = mapIcon;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public int getColom() {
        return colom;
    }

    public void setColom(int colom) {
        this.colom = colom;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setTileImage(String image) {
        setImage("Tiles//" + image + ".png");
        getImage().scale(TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
    }
}
