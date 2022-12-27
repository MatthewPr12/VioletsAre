package ua.edu.ucu.flowerstore.flowers;


public class FlowerPack {
    private final Flower flower;
    private final int quantity;
    public FlowerPack(Flower fl, int qua) {
        this.flower = fl;
        this.quantity = qua;
    }

    public double getPrice() {
        return flower.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "FlowerPack{" +
                "flower=" + flower +
                ", quantity=" + quantity +
                '}';
    }
}
