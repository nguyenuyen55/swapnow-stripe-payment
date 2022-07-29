package com.example.swapnowstripepayment.web.controller;

import com.example.swapnowstripepayment.dto.CreatePayment;
import com.example.swapnowstripepayment.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    static int calculateOrderAmount(Object[] items) {
        // Replace this constant with a calculation of the order's amount
        // Calculate the order total on the server to prevent
        // people from directly manipulating the amount on the client
        return 1400;
    }

@PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(15*100L) //có 15usd thanh toan
                        .setCurrency("usd")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();

        // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = PaymentIntent.create(params);

        CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
    return new CreatePaymentResponse(paymentIntent.getClientSecret());
    }
}
