package ru.job4j.lambda;

public class Product {
    private String name;
    private String manufacturer;
    private int quantity;
    private int expirationDate;
    private boolean delivered;

    static class Builder {
        private String name;
        private String manufacturer;
        private int quantity;
        private int expirationDate;
        private boolean delivered;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        Builder buildQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        Builder buildExpirationDate(int expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        Builder buildDelivered(boolean delivered) {
            this.delivered = delivered;
            return this;
        }

        Product build() {
            Product product = new Product();
            product.name = name;
            product.delivered = delivered;
            product.expirationDate = expirationDate;
            product.manufacturer = manufacturer;
            product.quantity = quantity;
            return product;
        }
    }

    public static void main(String[] args) {

        Product product = new Builder().buildName("name")
                .buildDelivered(true)
                .buildExpirationDate(12)
                .buildManufacturer("CoCo")
                .buildQuantity(100)
                .build();
        System.out.println(product);
    }

    @Override
    public String toString() {
        return "Product{"
                + "name='" + name + '\''
                + ", manufacturer='" + manufacturer + '\''
                + ", quantity=" + quantity
                + ", expirationDate=" + expirationDate
                + ", delivered=" + delivered
                + '}';
    }
}
