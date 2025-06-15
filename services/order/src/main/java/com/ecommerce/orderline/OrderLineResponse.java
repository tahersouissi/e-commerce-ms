package com.ecommerce.orderline;

public record OrderLineResponse(
        Integer id,
        double quantity
) { }