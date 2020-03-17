package by.training.khoroneko.parser;

import by.training.khoroneko.entity.ChocolateType;

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

    public static CandyTag getCandyTagByValue(String value) {
        CandyTag[] values = CandyTag.values();
        for (CandyTag candyTag : values) {
            if(candyTag.getTagName().equals(value)){
                return candyTag;
            }
        }
        throw new IllegalArgumentException();
    }
}
