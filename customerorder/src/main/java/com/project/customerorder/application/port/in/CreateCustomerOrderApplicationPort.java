package com.project.customerorder.application.port.in;

import com.project.customerorder.application.command.CreateCustomerOrderCommand;

import java.util.UUID;

public interface CreateCustomerOrderApplicationPort {
    UUID create(CreateCustomerOrderCommand command);
}
