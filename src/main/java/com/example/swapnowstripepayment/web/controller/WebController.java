package com.example.swapnowstripepayment.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";
    @Value("${stripe.public.key}")
    private String stripePublicKey;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("urlcancel", CANCEL_URL);
        model.addAttribute("urlsuccess", SUCCESS_URL);
        return "checkout";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay() {
        return "success";
    }
}
