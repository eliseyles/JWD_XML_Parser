package by.training.khoroneko.command;

public enum Attribute {
    CANDIES("candies"),
    INFORM_MESSAGE("informMessage");

    private String value;

    Attribute(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}
