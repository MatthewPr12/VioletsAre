package ua.edu.ucu.flowerstore.observer;

import lombok.Getter;
import lombok.Setter;
import ua.edu.ucu.flowerstore.appuser.AppUser;
import ua.edu.ucu.flowerstore.order.Order;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Publisher {
    private List<AppUser> subscribers = new ArrayList<>();
    private Order order;

    void subscribe(AppUser appUser){
        if(! subscribers.contains(appUser)){
            subscribers.add(appUser);
        }
    }

    void unsubscribe(AppUser appUser){
        subscribers.remove(appUser);
    }

    void notifySubscribers(){
        for(AppUser user: subscribers){
            System.out.println(user.getName());
            System.out.println("Your order is being processed");
            System.out.println(order.processOrder());
        }
    }
}
