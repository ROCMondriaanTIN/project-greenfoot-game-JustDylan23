import greenfoot.Actor;
import greenfoot.Greenfoot;

public class ClickableObject extends Actor {

    private String action;

    public ClickableObject(String image) {
        action = image.replace(".png", "");
        setImage(image);
        getImage().scale(553, 88);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            System.out.println(action);
            if (action.equals("startGame")) {
                Greenfoot.setWorld(new MyWorld());
            } else if (action.equals("exitGame")) {
                System.exit(0);
            }

        }
    }
}
