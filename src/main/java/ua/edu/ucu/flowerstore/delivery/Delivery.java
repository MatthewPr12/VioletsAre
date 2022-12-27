package ua.edu.ucu.flowerstore.delivery;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ua.edu.ucu.flowerstore.flowers.Item;

import java.io.IOException;
import java.util.List;

@JsonDeserialize(using = DeliveryDer.class)
public interface Delivery {
    void deliver(List<Item> items);
}


class DeliveryDer extends JsonDeserializer<Delivery> {

    @Override
    public Delivery deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        ObjectNode root = mapper.readTree(p);
        if (root.has("deliveryType") && root.get("deliveryType").asText().equals("DHL")) {
            return mapper.readValue(root.toString(), DHLDeliverStrategy.class);
        }
        return mapper.readValue(root.toString(), PostDeliverStrategy.class);
    }
}