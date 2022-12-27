package ua.edu.ucu.flowerstore.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.flowerstore.appuser.AppUser;
import ua.edu.ucu.flowerstore.flowers.*;
import ua.edu.ucu.flowerstore.order.Order;

class PublisherTest {
    protected Order order = new Order();
    protected AppUser appUser = new AppUser();

    Publisher publisher = new Publisher();

    @Test
    void subscribe() {
        publisher.subscribe(appUser);
        System.out.println(publisher.getSubscribers());
        assert publisher.getSubscribers().contains(appUser);
    }

    @Test
    void unsubscribe() {
        publisher.subscribe(appUser);
        publisher.unsubscribe(appUser);
        publisher.unsubscribe(new AppUser());
        assert !publisher.getSubscribers().contains(appUser);
    }

    @Test
    void notifySubscribers() {
        publisher.subscribe(appUser);
        publisher.setOrder(order);
        publisher.notifySubscribers();
        assert order.calculateTotalPrice() == 210;

    }

    @BeforeEach
    void setUp() {
        Flower flower1 = new Flower(10, FlowerColor.RED, 42);
        FlowerPack pack = new FlowerPack(flower1, 5);
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(pack);

        order.addItem(bucket);
        appUser.setAge(32);
        appUser.setName("Bob");
        appUser.setEmail("bob@gmail.com");
    }
}