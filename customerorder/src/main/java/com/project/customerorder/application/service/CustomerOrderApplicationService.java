package com.project.customerorder.application.service;

import com.project.customerorder.application.command.CreateCustomerOrderCommand;
import com.project.customerorder.application.mapper.CustomerOrderMapper;
import com.project.customerorder.application.port.in.CreateCustomerOrderApplicationPort;
import com.project.customerorder.domain.model.*;
import com.project.customerorder.domain.port.out.CustomerOrderRepositoryPort;

import java.util.UUID;

public class CustomerOrderApplicationService implements CreateCustomerOrderApplicationPort {
    private final CustomerOrderRepositoryPort repository;
    private final CustomerOrderMapper mapper;

    public CustomerOrderApplicationService(CustomerOrderRepositoryPort repository, CustomerOrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UUID create(CreateCustomerOrderCommand command) {
        CustomerOrder order = mapper.toDomain(command);
        repository.save(order);
        return order.getId().value();
    }
}
