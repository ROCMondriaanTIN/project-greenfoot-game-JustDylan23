package src;

import greenfoot.GreenfootImage;

public class HeroImages {

    private static final HeroImages instance = new HeroImages();
    private final GreenfootImage[] hero0 = new GreenfootImage[18];
    private GreenfootImage[] hero1 = new GreenfootImage[18];
    private GreenfootImage[] hero2 = new GreenfootImage[18];
    private GreenfootImage[] hero3 = new GreenfootImage[18];

    public GreenfootImage[][] heroImages = {hero0, hero1, hero2, hero3};

    public void loadImages() {
        for (int i = 1; i <= 3; i++) {
            heroImages[i][0] = image("p" + i + "_back");
            heroImages[i][1] = image("p" + i + "_duck");
            heroImages[i][2] = image("p" + i + "_fall");
            heroImages[i][3] = image("p" + i + "_front");
            heroImages[i][4] = image("p" + i + "_hurt");
            heroImages[i][5] = image("p" + i + "_jump");
            heroImages[i][6] = image("p" + i + "_stand");
            for (int i2 = 1; i2 <= 11; i2++) {
                heroImages[i][i2 + 6] = image("p" + i + "_walk//" + i2);
            }
        }
    }

    private GreenfootImage image(String imageName) {
        return new GreenfootImage("Player\\" + imageName + ".png");
    }

    public static HeroImages getInstance() {
        return instance;
    }
}
