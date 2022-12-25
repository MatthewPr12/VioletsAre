package ua.edu.ucu.flowerstore.flowers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flowers")
public class FlowerController {
    @GetMapping
    public List<Flower> getFlowers(){
        return List.of(new Flower(21, FlowerColor.BLUE, 102),
                new Flower(23, FlowerColor.VIOLET, 230),
                new Flower(12, FlowerColor.RED, 120));
    }
}
