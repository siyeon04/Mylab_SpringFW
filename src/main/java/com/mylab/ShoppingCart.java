package com.mylab;

import java.util.List;

public class ShoppingCart {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void printCart() {
        System.out.println("===== 장바구니 목록 =====");
        for (Product p : products) {
            System.out.println(" - " + p);
        }
    }
}