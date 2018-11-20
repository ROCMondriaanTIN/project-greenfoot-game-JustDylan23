import greenfoot.Greenfoot;
import greenfoot.World;

import src.Main;

public class MainClass extends World {

    public MainClass() {
        super(1000, 800, 1, false);
        Greenfoot.setWorld(new Main());
    }
}
