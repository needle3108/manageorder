package com.project.manufacturingorder.application.service;

import com.project.manufacturingorder.application.command.ChangeManufacturingOrderStatusCommand;
import com.project.manufacturingorder.application.port.in.ChangeManufacturingOrderStatusUseCase;
import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import com.project.manufacturingorder.domain.port.out.ManufacturingOrderRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangeManufacturingOrderStatusService implements ChangeManufacturingOrderStatusUseCase {
    private final ManufacturingOrderRepositoryPort repository;

    @Override
    public void changeStatus(ChangeManufacturingOrderStatusCommand command) {
        ManufacturingOrder order = repository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        order.changeStatus(command.status());
        repository.save(order);
    }
}
