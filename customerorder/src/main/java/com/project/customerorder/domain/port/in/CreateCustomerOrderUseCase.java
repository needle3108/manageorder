package com.project.customerorder.domain.port.in;

import com.project.customerorder.domain.model.CustomerOrder;

import java.util.List;

public interface CreateCustomerOrderUseCase {
    CustomerOrder create(List<CustomerOrder> orderLines);
}
