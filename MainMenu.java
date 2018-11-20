import greenfoot.Greenfoot;
import greenfoot.World;
import src.ClickableObject;

public class MainMenu extends World {

    public MainMenu() {
        super(1000, 800, 1, false);
        Greenfoot.start();
        setBackground("bg_menu.png");

        addObject(new ClickableObject("startGame.png"), 323 ,348);
        addObject(new ClickableObject("exitGame.png"), 323 ,548);
    }
}
