package com.project.manufacturingorder.application.command;

import com.project.manufacturingorder.domain.model.ManufacturingOrderStatus;

import java.util.UUID;

public record ChangeManufacturingOrderStatusCommand(UUID id, ManufacturingOrderStatus status) {
}
