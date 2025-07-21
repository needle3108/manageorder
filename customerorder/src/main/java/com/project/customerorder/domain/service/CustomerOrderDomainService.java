package com.project.customerorder.domain.service;

import com.project.customerorder.domain.model.CustomerOrder;
import com.project.customerorder.domain.model.CustomerOrderStatus;

public class CustomerOrderDomainService {
    public void validateStatusChange(CustomerOrder order, CustomerOrderStatus newStatus) {
        if (order.getStatus() == CustomerOrderStatus.COMPLETED && newStatus != CustomerOrderStatus.COMPLETED) {
            throw new IllegalStateException("Can't change status from COMPLETED");
        }
    }
}
