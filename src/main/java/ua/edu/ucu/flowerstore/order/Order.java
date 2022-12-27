package ua.edu.ucu.flowerstore.order;

import lombok.AllArgsConstructor;
import ua.edu.ucu.flowerstore.delivery.Delivery;
import ua.edu.ucu.flowerstore.flowers.Item;
import ua.edu.ucu.flowerstore.payment.Payment;

import java.util.LinkedList;

@AllArgsConstructor
public class Order {

    private LinkedList<Item> items;
    private Payment payment;
    private Delivery delivery;

    public Order() {
        items = new LinkedList<>();
    }

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }
    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }
    public float calculateTotalPrice(){
        float res = 0;
        for(Item it: items){
            res += it.price();
        }
        return res;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public String processOrder(){
        float price = calculateTotalPrice();
        String paymnt = ((payment==null)? "null":payment.toString());
        String delivr = ((delivery==null)? "null":delivery.toString());
        String itemStr = "";
        for(Item i: items){
            itemStr.concat(i.toString() + "; ");
        }
        return "YourOrder : " + "items : " + itemStr
         + ", paymentStrategy : " + paymnt
                + ", deliveryStrategy : " + delivr
                + ", totalPrice : " + price;
    }

}
