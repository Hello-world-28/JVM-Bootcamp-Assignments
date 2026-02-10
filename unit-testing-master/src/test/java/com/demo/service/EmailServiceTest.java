package com.demo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    private EmailService emailService = new EmailService();

    @Test(expected = RuntimeException.class)
    public void sendEmail_shouldThrowException_andSetCustomerNotifiedFalse() {
        Order order = new Order(1, "Item", 100.0);
        order.setCustomerNotified(true);

        try {
            emailService.sendEmail(order);
        } finally {
            assertFalse(order.isCustomerNotified());
        }
    }

    @Test
    public void sendEmailWithCc_shouldReturnTrue_andSetCustomerNotifiedTrue() {
        Order order = new Order(1, "Item", 100.0);

        boolean result = emailService.sendEmail(order, "cc@example.com");

        assertTrue(result);
        assertTrue(order.isCustomerNotified());
    }
}