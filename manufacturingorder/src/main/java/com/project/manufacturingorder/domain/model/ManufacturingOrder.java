package com.project.manufacturingorder.domain.model;

import java.util.UUID;

public class ManufacturingOrder {
    private final ManufacturingOrderId id = new ManufacturingOrderId(UUID.randomUUID());
    private ManufacturingOrderStatus status;

    public ManufacturingOrder(ManufacturingOrderId id, ManufacturingOrderStatus status) {
        this.status = status;
    }

    public void changeStatus(ManufacturingOrderStatus newStatus) {
        this.status = newStatus;
    }

    public ManufacturingOrderId getId() { return id; }
    public ManufacturingOrderStatus getStatus() { return status; }
}
