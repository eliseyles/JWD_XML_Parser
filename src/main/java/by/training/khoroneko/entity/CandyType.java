package by.training.khoroneko.entity;

public enum CandyType {
    CARAMEL("caramel"),
    CHOCOLATE_WITH_FILING("chocolate with filing"),
    CHOCOLATE_WITHOUT_FILING("chocolate without filing");

    private String type;

    CandyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static CandyType getCandyTypeByValue(String value) {
        CandyType[] values = CandyType.values();
        for (CandyType candyType : values) {
            if(candyType.getType().equals(value)){
                return candyType;
            }
        }
        throw new IllegalArgumentException();
    }
}
