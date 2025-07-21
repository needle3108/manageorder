package com.project.customerorder.domain.model;

import java.util.UUID;

public record CustomerOrderId(UUID value) {
    public static CustomerOrderId random() {
        return new CustomerOrderId(UUID.randomUUID());
    }
}
