package ru.job4j.pojo;

import ru.job4j.oop.Product;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            if(i >= index) {
                products[i] = null;
                if (i < products.length - 1) {
                    products[i] = products[i + 1];
                }
            }

        }
        return products;
    }
}
