package ua.edu.ucu.flowerstore.flowers;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Flower extends Item {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;
    public Flower(double sepLength, FlowerColor color, double price){
        this.sepalLength = sepLength;
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color.toString();
    }

    @Override
    public String toString() {
        return "Flower{"
                + "sepalLength=" + sepalLength
                + ", color=" + color
                + ", price=" + price
                + '}';
    }

    @Override
    public double price() {
        return getPrice();
    }
}
