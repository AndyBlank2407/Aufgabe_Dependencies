package de.neuefische.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    /*
    @Test
    public void listProducts_whenList_thenProducts() {
        ProductRepo productRepo = Mockito.mock(ProductRepo.class);
        Mockito.when(productRepo.list()).thenReturn(List.of(new Product("10", "Bannane")));

        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Assertions.assertEquals(
                List.of(new Product("10", "Bannane")),
                shopService.listProducts()
        );

        Mockito.verify(productRepo).list(); }
     */
    @Test
    public void listProducts_whenList_thenProducts(){
        //Given
        ProductRepo productRepo = Mockito.mock(ProductRepo.class);
        Mockito.when(productRepo.list()).thenReturn(List.of(new Product("10", "Banane")));

        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Assertions.assertEquals(
                List.of(new Product("10", "Banane")),
                shopService.listProducts());

            Mockito.verify(productRepo).list();

    }

    @Test
    public void whenGetProductWithId1ThenRepoGetWithId1(){
        ProductRepo productRepo = Mockito.mock(ProductRepo.class);

        Mockito.when(productRepo.get("2")).thenReturn(new Product("5", "Kartoffel"));

        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Assertions.assertEquals(new Product("5", "Kartoffel"), shopService.getProduct("2"));

        Mockito.verify(productRepo).get("2");

    }

    @Test
    public void whenGetOrderWithId1ThenOrderRepoGetWith1(){
        OrderRepo orderRepo = Mockito.mock(OrderRepo.class);

        Mockito.when(orderRepo.get("3")).thenReturn(new Order("4", List.of(new Product("8", "CurryWurst"))));

        ProductRepo productRepo = new ProductRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Assertions.assertEquals(new Order("4", List.of(new Product("8", "CurryWurst"))), shopService.getOrder("3"));
        Mockito.verify(orderRepo).get("3");
    }

    @Test
    public void listProducts_WhenList_ThenProducts(){
        OrderRepo orderRepo = Mockito.mock(OrderRepo.class);

        Mockito.when(orderRepo.list()).thenReturn(List.of(new Order("3", List.of(new Product("2", "Karotte")))));

        ProductRepo productRepo = new ProductRepo();
        ShopService shopService = new ShopService(productRepo,orderRepo);

        Assertions.assertEquals(List.of(new Order("3", List.of(new Product("2","Karotte")))),
                shopService.listOrders());

        Mockito.verify(orderRepo).list();
    }

}