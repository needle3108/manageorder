package com.project.customerorder.domain.port.out;

import com.project.customerorder.domain.model.ManufacturingOrderStatusDto;

import java.util.UUID;

public interface ManufacturingOrderStatusPort {
    ManufacturingOrderStatusDto getStatus(UUID orderId);
}
