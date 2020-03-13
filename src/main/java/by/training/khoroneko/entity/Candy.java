package by.training.khoroneko.entity;

import java.util.Objects;

public class Candy {
    private String name;
    private int energy;
    private CandyType candyType;
    private Ingredient ingredient;
    private Value value;
    private String production;
    private String id;

    public Candy() {
    }

    public Candy(String name, int energy, CandyType candyType, Ingredient ingredient, Value value, String production, String id) {
        this.name = name;
        this.energy = energy;
        this.candyType = candyType;
        this.ingredient = ingredient;
        this.value = value;
        this.production = production;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public CandyType getCandyType() {
        return candyType;
    }

    public void setCandyType(CandyType candyType) {
        this.candyType = candyType;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return energy == candy.energy &&
                Objects.equals(name, candy.name) &&
                candyType == candy.candyType &&
                Objects.equals(ingredient, candy.ingredient) &&
                Objects.equals(value, candy.value) &&
                Objects.equals(production, candy.production) &&
                Objects.equals(id, candy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, energy, candyType, ingredient, value, production, id);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", candyType=" + candyType +
                ", ingredient=" + ingredient +
                ", value=" + value +
                ", production='" + production + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
