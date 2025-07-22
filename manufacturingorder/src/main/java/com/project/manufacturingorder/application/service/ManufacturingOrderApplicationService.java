package com.project.manufacturingorder.application.service;

import com.project.manufacturingorder.application.command.CreateManufacturingOrderCommand;
import com.project.manufacturingorder.application.mapper.ManufacturingOrderMapper;
import com.project.manufacturingorder.application.port.in.CreateManufacturingOrderApplicationPort;
import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import com.project.manufacturingorder.domain.port.out.ManufacturingOrderRepositoryPort;

import java.util.UUID;

public class ManufacturingOrderApplicationService implements CreateManufacturingOrderApplicationPort {
    private final ManufacturingOrderRepositoryPort repository;
    private final ManufacturingOrderMapper mapper;

    public ManufacturingOrderApplicationService(ManufacturingOrderRepositoryPort repository, ManufacturingOrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UUID create(CreateManufacturingOrderCommand command){
        ManufacturingOrder order = mapper.toDomain(command);
        repository.save(order);
        return order.getId().value();
    }
}
