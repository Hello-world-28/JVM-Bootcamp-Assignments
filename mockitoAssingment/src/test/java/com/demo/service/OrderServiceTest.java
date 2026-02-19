package com.demo.service;


import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    private EmailService emailService;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void shouldPlaceOrderAndSendEmail() {

        // given
        Order order = new Order(2, "Phone", 100);

        // when
        orderService.placeOrder(order);

        // then

        // verify tax calculation (20% of 100 = 20 → stored as 120 )
        assertEquals(120, order.getPriceWithTax(), 0.01);

        // verify email service called
        verify(emailService).sendEmail(order);

        // verify customer notified flag
        assertTrue(order.isCustomerNotified());
    }

    @Test
    public void shouldPlaceOrderWithCCAndNotifyCustomer() {

        // given
        Order order = new Order(1, "Laptop", 200);

        // mock email service behavior or also called stubbing
        when(emailService.sendEmail(order, "padam@gmail.com"))
                .thenReturn(true);

        // when
        boolean result = orderService.placeOrder(order, "padam@gmail.com");

        // then

        // verify return value
        assertTrue(result);

        // verify tax calculation (200 + 40 = 240)
        assertEquals(240, order.getPriceWithTax(), 0.01);

        // verify email called with cc
        verify(emailService).sendEmail(order, "padam@gmail.com");

        // verify notification flag updated
        assertTrue(order.isCustomerNotified());
    }


}
