package src.entities;

public enum EntityType {
    KEY_BLUE ("keyBlue"),
    KEY_GREEN ("keyGreen"),
    KEY_RED ("keyRed"),
    KEY_YELLOW("keyYellow"),

    STAR ("star"),
    COIN ("coin"),
    GEM("gem"),
    CHARACTER_COIN_1 ("characterCoin1"),
    CHARACTER_COIN_2 ("characterCoin2"),
    CHARACTER_COIN_3 ("characterCoin3"),

    SPIKES ("spikes"),
    SPRINGBOARD ("springboard"),

    FLY ("fly"),
    SLIME ("slime"),
    POKER ("poker"),
    FIREBALL ("fireBall");

    private String text;

    EntityType(String text) {
        this.text = text;
    }

    public static EntityType fromString(String text) {
        for (EntityType entityType : EntityType.values()) {
            if (entityType.text.equalsIgnoreCase(text)) {
                return entityType;
            }
        }
        return null;
    }
}
