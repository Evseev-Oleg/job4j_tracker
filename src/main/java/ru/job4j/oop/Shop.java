package ru.job4j.oop;

import java.lang.*;

public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName());
            }
        }
    }

//    public static Product of(String name, int price) {
//        if ("Oil".equals(name)) {
//            return new LiquidationProduct(name, price).getProduct();
//        }
//        return new Product(name, price);
//    }

    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
