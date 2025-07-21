package com.project.customerorder.domain.event;

import com.project.customerorder.domain.model.CustomerOrderId;

public record CustomerOrderCreatedEvent(CustomerOrderId orderId) {
}
