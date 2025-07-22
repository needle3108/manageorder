package com.project.manufacturingorder.domain.service;

import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import com.project.manufacturingorder.domain.model.ManufacturingOrderStatus;

public class ManufacturingOrderDomainService {
    public void validateStatusChange(ManufacturingOrder manufacturingOrder, ManufacturingOrderStatus newStatus) {
        if (manufacturingOrder.getStatus() == ManufacturingOrderStatus.COMPLETED && newStatus != ManufacturingOrderStatus.COMPLETED) {
            throw new IllegalStateException("Can't change status from COMPLETED");
        }
    }
}
