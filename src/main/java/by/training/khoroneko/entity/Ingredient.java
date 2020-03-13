package by.training.khoroneko.entity;

public class Ingredient {
    private int water;
    private int sugar;
    private int fructose;
    private ChocolateType chocolateType;

    public Ingredient(int water, int sugar, int fructose, ChocolateType chocolateType) {
        this.water = water;
        this.sugar = sugar;
        this.fructose = fructose;
        this.chocolateType = chocolateType;
    }

    public Ingredient() {
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }
}
