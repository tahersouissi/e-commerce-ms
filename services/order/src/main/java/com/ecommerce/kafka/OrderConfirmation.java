package com.ecommerce.kafka;

import com.ecommerce.customer.CustomerResponse;
import com.ecommerce.order.PaymentMethod;
import com.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}