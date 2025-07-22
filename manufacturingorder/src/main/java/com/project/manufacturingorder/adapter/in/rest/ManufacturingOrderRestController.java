package com.project.manufacturingorder.adapter.in.rest;

import com.project.manufacturingorder.application.command.CreateManufacturingOrderCommand;
import com.project.manufacturingorder.application.port.in.CreateManufacturingOrderApplicationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class ManufacturingOrderRestController {
    private final CreateManufacturingOrderApplicationPort createOrder;

    @PostMapping
    public ResponseEntity<UUID> createManufacturingOrder(@RequestBody CreateManufacturingOrderCommand command) {
        UUID orderId = createOrder.create(command);
        return ResponseEntity.ok(orderId);
    }
}
