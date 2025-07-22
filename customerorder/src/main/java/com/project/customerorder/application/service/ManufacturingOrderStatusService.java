package com.project.customerorder.application.service;

import com.project.customerorder.domain.model.ManufacturingOrderStatusDto;
import com.project.customerorder.domain.port.out.ManufacturingOrderStatusPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManufacturingOrderStatusService {
    private final ManufacturingOrderStatusPort manufacturingOrderStatusPort;

    public ManufacturingOrderStatusDto getManufacturingOrderStatus(UUID orderId) {
        return manufacturingOrderStatusPort.getStatus(orderId);
    }
}
