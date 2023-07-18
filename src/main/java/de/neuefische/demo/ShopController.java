package de.neuefische.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopService")
@RequiredArgsConstructor
public class ShopController {

    public final ShopController shopController;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/get")
    public List<Product> getProducts() {
        return shopController.getProducts();
    }
}
