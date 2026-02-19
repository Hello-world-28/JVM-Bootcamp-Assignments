package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    private EmailService emailService = new EmailService();

    /** test have these fields
     * Test sendEmail(order)
     * Should throw RuntimeException
     * Should set notification flag to false
     */
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenSendingEmail() {

        Order order = new Order();

        try {
            emailService.sendEmail(order);
        } finally {
            // verify flag updated before exception
            assertFalse(order.isCustomerNotified());
        }
    }

    /**
     * Test sendEmail(order, cc)
     * Should return true
     * Should set notification flag to true
     */
    @Test
    public void shouldSendEmailWithCCSuccessfully() {

        Order order = new Order();

        boolean result = emailService.sendEmail(order, "padam@gmail.com");

        assertTrue(result);
        assertTrue(order.isCustomerNotified());
    }

}