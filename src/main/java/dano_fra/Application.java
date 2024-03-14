package dano_fra;

import com.github.javafaker.Faker;
import dano_fra.entities.Customers;
import dano_fra.entities.Order;
import dano_fra.entities.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        LocalDate date = LocalDate.now();
        //CATEGORY LIST
        List<String> categoryProduct = new ArrayList<>();
        categoryProduct.add("Baby");
        categoryProduct.add("Boys");
        categoryProduct.add("Books");
        //STATUS LIST
        List<String> statusOrder = new ArrayList<>();
        statusOrder.add("NEW");
        statusOrder.add("IN_PROGRESS");
        statusOrder.add("DELIVERED");
        //PRODUCT RANDOM
        Supplier<Product> useSupplierProduct = () -> {
            Faker faker = new Faker(Locale.ITALY);
            return new Product(
                    faker.name().title(),
                    categoryProduct.get(random.nextInt(0,3)),
                    random.nextDouble(1,100));
        };
        List<Product> productList = new ArrayList<>();
        List<Product> productList1 = new ArrayList<>();
        List<Product> productList2 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            productList.add(useSupplierProduct.get());
        }
        for (int i = 0; i < 3; i++) {
            productList1.add(useSupplierProduct.get());
        }
        for (int i = 0; i < 3; i++) {
            productList2.add(useSupplierProduct.get());
        }

    // CUSTOMERS RANDOM
    Supplier<Customers> useSupplierCustomers = () -> {
        Faker faker = new Faker(Locale.ITALY);
        return new Customers(
                faker.dragonBall().character(),
                random.nextInt(0,5));
    };
    List<Customers> customersList = new ArrayList<>();
        for( int i = 0; i< 10;i++){
        customersList.add(useSupplierCustomers.get());
    }

        // ORDER RANDOM
        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order( statusOrder.get(random.nextInt(0,3)), date, productList, customersList.get(random.nextInt(0,3)));
        Order order2 = new Order( statusOrder.get(random.nextInt(0,3)), date, productList1, customersList.get(random.nextInt(0,3)));
        Order order3 = new Order( statusOrder.get(random.nextInt(0,3)), date, productList2, customersList.get(random.nextInt(0,3)));
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        Map<String, List<Order>> orderCustomers= orderList.stream().collect(Collectors.groupingBy(order->order.getCustomerList().getName()));
        System.out.println("Ordini Clienti: " + orderCustomers);



}
}

