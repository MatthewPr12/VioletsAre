package ua.edu.ucu.demo.flowers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @ToString @Setter @AllArgsConstructor
public class FlowerBucket extends Item {
    private final List<FlowerPack> flowers = new ArrayList<>();

    public double price(){
        return getPrice();
    }
    public void add(FlowerPack fp) {
        flowers.add(fp);
    }

    public double getPrice() {
        double res = 0;
        for (FlowerPack i: flowers) {
            res += i.getPrice();
        }
        return res;
    }
}
