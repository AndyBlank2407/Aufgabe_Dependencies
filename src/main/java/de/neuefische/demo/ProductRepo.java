package de.neuefische.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {
    private List<Product> products = new ArrayList<>();

    public ProductRepo() {
        products.add( new Product("1","Wurst"));
        products.add(new Product("2","Salat"));
    }

    public List<Product> list() {
        return products;
    }

    public Product get(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }
}
