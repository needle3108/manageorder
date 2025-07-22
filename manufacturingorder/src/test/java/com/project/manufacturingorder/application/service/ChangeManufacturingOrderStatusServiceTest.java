package com.project.manufacturingorder.application.service;

import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import com.project.manufacturingorder.domain.model.ManufacturingOrderId;
import com.project.manufacturingorder.domain.model.ManufacturingOrderStatus;
import com.project.manufacturingorder.domain.service.ManufacturingOrderDomainService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeManufacturingOrderStatusServiceTest {
    private final ManufacturingOrderDomainService domainService = new ManufacturingOrderDomainService();

    @Test
    void shouldAllowChangeStatusIfNotFromCompleted() {
        var order = new ManufacturingOrder(new ManufacturingOrderId(UUID.randomUUID()), ManufacturingOrderStatus.CREATED);
        assertDoesNotThrow(() -> domainService.validateStatusChange(order, ManufacturingOrderStatus.CONFIRMED));
    }

    @Test
    void shouldAllowChangingStatusToCompleted() {
        var order = new ManufacturingOrder(new ManufacturingOrderId(UUID.randomUUID()), ManufacturingOrderStatus.CREATED);
        assertDoesNotThrow(() -> domainService.validateStatusChange(order, ManufacturingOrderStatus.COMPLETED));
    }

    @Test
    void shouldNotAllowChangingStatusFromCompletedToOther() {
        var order = new ManufacturingOrder(new ManufacturingOrderId(UUID.randomUUID()), ManufacturingOrderStatus.COMPLETED);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                domainService.validateStatusChange(order, ManufacturingOrderStatus.CONFIRMED));
        assertEquals("Can't change status from COMPLETED", exception.getMessage());
    }
}
