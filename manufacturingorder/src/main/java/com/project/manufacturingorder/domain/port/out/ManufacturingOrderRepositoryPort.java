package com.project.manufacturingorder.domain.port.out;

import com.project.manufacturingorder.domain.model.ManufacturingOrder;

import java.util.Optional;
import java.util.UUID;

public interface ManufacturingOrderRepositoryPort {
    void save(ManufacturingOrder manufacturingOrder);
    Optional<ManufacturingOrder> findById(UUID id);
}
