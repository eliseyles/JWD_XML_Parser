package by.training.khoroneko.entity;

public class Value {
    private int protein;
    private int fat;
    private int carbohydrates;

    public Value() {
    }

    public Value(int protein, int fat, int carbohydrates) {
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
