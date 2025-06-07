package com.naim.ecommerce.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

  public Payment toPayment(PaymentRequest request) {
    if (request == null) {
      return null;
    }
    return Payment.builder()
        .id(String.valueOf(request.id()))
        .paymentMethod(String.valueOf(request.paymentMethod()))
        .amount(request.amount())
        .orderId(String.valueOf(request.orderId()))
        .build();
  }
}
