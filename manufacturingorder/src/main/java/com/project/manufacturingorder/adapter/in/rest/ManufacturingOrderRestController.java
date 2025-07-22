package com.project.manufacturingorder.adapter.in.rest;

import com.project.manufacturingorder.application.command.ChangeManufacturingOrderStatusCommand;
import com.project.manufacturingorder.application.command.CreateManufacturingOrderCommand;
import com.project.manufacturingorder.application.port.in.ChangeManufacturingOrderStatusUseCase;
import com.project.manufacturingorder.application.port.in.CreateManufacturingOrderApplicationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class ManufacturingOrderRestController {
    private final CreateManufacturingOrderApplicationPort createOrder;
    private final ChangeManufacturingOrderStatusUseCase changeStatusUseCase;

    @PostMapping
    public ResponseEntity<UUID> createManufacturingOrder(@RequestBody CreateManufacturingOrderCommand command) {
        UUID orderId = createOrder.create(command);
        return ResponseEntity.ok(orderId);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> changeStatus(@PathVariable UUID id, @RequestBody ChangeStatusDto dto) {
        changeStatusUseCase.changeStatus(new ChangeManufacturingOrderStatusCommand(id, dto.status()));
        return ResponseEntity.noContent().build();
    }
}
