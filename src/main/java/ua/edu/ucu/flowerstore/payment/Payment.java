package ua.edu.ucu.flowerstore.payment;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

@JsonDeserialize(using = PaymentDer.class)
public interface Payment {
    void pay(double price);
}


class PaymentDer extends JsonDeserializer<Payment> {

    @Override
    public Payment deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        ObjectNode root = mapper.readTree(p);
        if (root.has("paymentType") && root.get("paymentType").asText().equals("card")) {
            return mapper.readValue(root.toString(), CreditCardPaymentStrategy.class);
        }
        return mapper.readValue(root.toString(), PayPalPaymentStrategy.class);
    }
}
