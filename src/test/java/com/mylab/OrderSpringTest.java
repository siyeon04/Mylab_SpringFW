package com.mylab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private OrderService orderService;

    @Test
    void testShoppingCart() {

        assertNotNull(shoppingCart, "shoppingCart Bean이 null이면 안 됩니다.");

        assertNotNull(shoppingCart.getProducts(), "products 리스트가 null이면 안 됩니다.");
        assertEquals(2, shoppingCart.getProducts().size(),
                "products 리스트의 크기는 2이어야 합니다.");

        assertEquals("노트북", shoppingCart.getProducts().get(0).getName(),
                "첫 번째 상품 이름은 '노트북'이어야 합니다.");

        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName(),
                "두 번째 상품 이름은 '스마트폰'이어야 합니다.");

        shoppingCart.printCart();
    }

    @Test
    void testOrderService() {
        assertNotNull(orderService, "orderService Bean이 null이면 안 됩니다.");

        assertNotNull(orderService.getShoppingCart(),
                "orderService에 shoppingCart가 주입되어야 합니다.");

        assertEquals(2, orderService.getShoppingCart().getProducts().size(),
                "orderService의 장바구니에는 상품 2개가 있어야 합니다.");

        assertDoesNotThrow(() -> orderService.placeOrder(),
                "placeOrder() 실행 중 예외가 발생하면 안 됩니다.");
    }
}