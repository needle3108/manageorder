package com.project.customerorder.application.command;

import java.util.List;

public record CreateCustomerOrderCommand(List<OrderLineDto> lines) {
    public record OrderLineDto(String productId, int quantity) {}
}
