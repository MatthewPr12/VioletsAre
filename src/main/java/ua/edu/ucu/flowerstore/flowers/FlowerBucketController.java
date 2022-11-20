package ua.edu.ucu.demo.flowers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flower-bucket")
public class FlowerBucketController {
    @GetMapping
    public List<Flower> getFlowers(){
        return List.of(new Flower(21, FlowerColor.RED, 123));
    }

}
