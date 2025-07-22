package com.project.manufacturingorder.domain.model;

import java.util.UUID;

public class ManufacturingOrder {
    private final ManufacturingOrderId id;
    private ManufacturingOrderStatus status;

    public ManufacturingOrder(ManufacturingOrderId id, ManufacturingOrderStatus status) {
        this.id = id;
        this.status = status;
    }

    public void changeStatus(ManufacturingOrderStatus newStatus) {
        this.status = newStatus;
    }

    public ManufacturingOrderId getId() { return id; }
    public ManufacturingOrderStatus getStatus() { return status; }
}
