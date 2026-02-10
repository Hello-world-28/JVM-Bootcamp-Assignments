package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderServiceTest {

    private OrderService orderService = new OrderService();

    @Test
    public void placeOrder_shouldThrowException_andSetPriceWithTax_andNotNotifyCustomer() {
        Order order = new Order(1, "Item", 100.0);

        try {
            orderService.placeOrder(order);
        } catch (RuntimeException ex) {
            // verify the exception message from EmailService
            assertEquals("An Exception Occurred", ex.getMessage());
        }

        // priceWithTax is set via Order.setPriceWithTax(price + priceWithTax)
        assertEquals(120.0, order.getPriceWithTax(), 0.0);
        // customer should not be marked as notified because sendEmail throws before the flag is set
        assertFalse(order.isCustomerNotified());
    }

    @Test
    public void placeOrderWithCc_shouldSetPriceWithTax_andNotifyCustomer() {
        Order order = new Order(1, "Item", 200.0);

        boolean result = orderService.placeOrder(order, "cc@example.com");

        assertEquals(240.0, order.getPriceWithTax(), 0.0);
        assertTrue(result);
        assertTrue(order.isCustomerNotified());
    }
}

