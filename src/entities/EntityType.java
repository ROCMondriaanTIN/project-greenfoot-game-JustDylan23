package src.entities;

public enum EntityType {
    KEY_BLUE ("blueKey"),
    KEY_GREEN ("greenKey"),
    KEY_RED ("redKey"),
    KEY_YELLOW("yellowKey"),

    STAR ("star"),
    COIN ("coin"),
    GEM("gem"),

    SPIKES ("spikes"),
    SPRINGBOARD ("springboard"),

    FLY ("fly"),
    SLIME ("slime"),
    POKER ("poker");

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
