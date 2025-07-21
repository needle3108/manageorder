package com.project.customerorder.domain.model;

import java.util.List;

public class CustomerOrder {
    private final CustomerOrderId id;
    private final List<OrderLine> orderLines;
    private CustomerOrderStatus status;

    public CustomerOrder(List<OrderLine> orderLines) {
        this.id = CustomerOrderId.random();
        this.orderLines = orderLines;
        this.status = CustomerOrderStatus.CREATED;
    }

    public void changeStatus(CustomerOrderStatus newStatus) {
        this.status = newStatus;
    }

    public CustomerOrderId getId() { return id; }
    public List<OrderLine> getOrderLines() { return orderLines; }
    public CustomerOrderStatus getStatus() { return status; }
}
