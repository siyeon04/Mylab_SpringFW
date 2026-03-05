package com.mylab;

public class OrderService {

    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void placeOrder() {
        System.out.println("===== 주문 처리 =====");
        for (Product p : shoppingCart.getProducts()) {
            System.out.println("상품: " + p.getName() + " / 가격: " + p.getPrice());
        }
    }
}