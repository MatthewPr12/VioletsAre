package ua.edu.ucu.demo.flowers;

import lombok.Getter;

public abstract class Item {
    @Getter
    private String description;
    public abstract double price();



}
