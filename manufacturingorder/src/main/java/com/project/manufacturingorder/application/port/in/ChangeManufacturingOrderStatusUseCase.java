package com.project.manufacturingorder.application.port.in;

import com.project.manufacturingorder.application.command.ChangeManufacturingOrderStatusCommand;

public interface ChangeManufacturingOrderStatusUseCase {
    void changeStatus(ChangeManufacturingOrderStatusCommand command);
}
