package ua.edu.ucu.flowerstore.flowers;

import lombok.Getter;
import lombok.Setter;

@Setter
public class CactusFlower extends Item {
    @Getter
    private double sepalLength;
    @Getter
    private FlowerColor color;
    @Getter
    private double price;

    public CactusFlower(double sepLength, FlowerColor flowerColor, double price) {
        this.sepalLength = sepLength;
        this.color = flowerColor;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CactusFlower{"
                + "sepalLength=" + getSepalLength()
                + ", color=" + getColor()
                + ", price=" + getPrice()
                + '}';
    }

    @Override
    public double price(){
        return getPrice();
    }

}
