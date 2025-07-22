package com.project.manufacturingorder.domain.port.out;

import com.project.manufacturingorder.domain.model.ManufacturingOrder;

public interface ManufacturingOrderRepositoryPort {
    void save(ManufacturingOrder manufacturingOrder);
}
