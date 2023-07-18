package de.neuefische.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopService")
@RequiredArgsConstructor
public class ShopController {

    public final ShopService shopService;

    /*

    Constructor brauch ich nicht, weil Annot. "@RequiredArgsConstructor" automat. im Hintergrund
    den ShopService-Construct. mit den req. Attr, dem final Attribut "shopService", erstellt.
    Final-Variablen müssen immer initialisiert werden (können auch nicht mehr geändert werden)
    und sind damit für den Konstruktor required...

    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }

     */


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/getAllProduct")
    public List<Product> getProducts() {
        return shopService.listProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return shopService.getProduct(id);
    }
}
