package by.training.khoroneko.entity;

public enum ChocolateType {
    MILK("milk"),
    DARK("dark"),
    WHITE("white"),
    NONE("none");

    private String chocolateType;

    ChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }
}
