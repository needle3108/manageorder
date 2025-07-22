package com.project.manufacturingorder.application.service;

import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import com.project.manufacturingorder.domain.model.ManufacturingOrderStatus;
import com.project.manufacturingorder.domain.port.out.ManufacturingOrderRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManufacturingOrderQueryService {
    private final ManufacturingOrderRepositoryPort repository;

    public Optional<ManufacturingOrderStatus> findStatusById(UUID id) {
        return repository.findById(id).map(ManufacturingOrder::getStatus);
    }
}
