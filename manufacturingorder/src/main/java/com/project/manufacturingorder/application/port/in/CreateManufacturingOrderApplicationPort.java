package com.project.manufacturingorder.application.port.in;

import com.project.manufacturingorder.application.command.CreateManufacturingOrderCommand;

import java.util.UUID;

public interface CreateManufacturingOrderApplicationPort {
    UUID create (CreateManufacturingOrderCommand command);
}
