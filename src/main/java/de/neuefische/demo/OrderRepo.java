package de.neuefische.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepo {
    private List<Order> orders = new ArrayList<>();

    public List<Order> list() {
        return orders;
    }

    public Order get(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }

        return null;
    }

    public void add(Order order) {
        orders.add(order);
    }
}
