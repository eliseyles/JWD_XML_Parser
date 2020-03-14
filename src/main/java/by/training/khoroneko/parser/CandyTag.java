package by.training.khoroneko.parser;

public enum CandyTag {
    CANDIES("candies"),
    CANDY("candy"),
    ID("id"),
    ENERGY("energy"),
    NAME("name"),
    TYPE("type"),
    INGREDIENTS("ingredients"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    CHOCOLATE_TYPE("chocolate_type"),
    VALUE("value"),
    FAT("fat"),
    PROTEIN("protein"),
    CARBOHYDRATES("carbohydrates"),
    PRODUCTION("production");

    private String tagName;

    CandyTag(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
}
