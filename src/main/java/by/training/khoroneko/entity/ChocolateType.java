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

    public String getChocolateType() {
        return chocolateType;
    }

    public static ChocolateType getChocolateTypeByValue(String value) {
        ChocolateType[] values = ChocolateType.values();
        for (ChocolateType chocolateType : values) {
            if(chocolateType.getChocolateType().equals(value)){
                return chocolateType;
            }
        }
        throw new IllegalArgumentException();
    }
}
