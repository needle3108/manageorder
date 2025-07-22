package com.project.customerorder.domain.model;

import java.util.List;

public class CustomerOrder {
    private final CustomerOrderId id;
    private final List<OrderLine> orderLines;
    private CustomerOrderStatus status;

    public CustomerOrder(CustomerOrderId id, List<OrderLine> orderLines, CustomerOrderStatus status) {
        this.id = id;
        this.orderLines = orderLines;
        this.status = status;
    }

    public CustomerOrderId getId() { return id; }
    public List<OrderLine> getOrderLines() { return orderLines; }
    public CustomerOrderStatus getStatus() { return status; }
}
