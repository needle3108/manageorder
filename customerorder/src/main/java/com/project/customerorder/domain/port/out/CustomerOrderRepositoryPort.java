package com.project.customerorder.domain.port.out;

import com.project.customerorder.domain.model.CustomerOrder;

public interface CustomerOrderRepositoryPort {
    void save(CustomerOrder order);
}
