package src.entities.gameplayobjects;

public class SpringBoard extends GamePlayObject {

    private boolean isDown;

    public SpringBoard () {
        super();
        setImage("Items\\springboardUp.png");
    }

    public void setDownState(boolean downState) {
        isDown = downState;
        if (isDown) {
            setImage("Items\\springboardDown.png");
        } else setImage("Items\\springboardUp.png");
    }
}
