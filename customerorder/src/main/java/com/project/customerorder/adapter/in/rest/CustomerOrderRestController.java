package com.project.customerorder.adapter.in.rest;

import com.project.customerorder.application.command.CreateCustomerOrderCommand;
import com.project.customerorder.application.port.in.CreateCustomerOrderApplicationPort;
import com.project.customerorder.application.service.ManufacturingOrderStatusService;
import com.project.customerorder.domain.model.ManufacturingOrderStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class CustomerOrderRestController {
    private final CreateCustomerOrderApplicationPort createOrder;
    private final ManufacturingOrderStatusService manufacturingOrderStatusService;

    @PostMapping
    public ResponseEntity<UUID> createCustomerOrder(@RequestBody CreateCustomerOrderCommand command) {
        UUID orderId = createOrder.create(command);
        return ResponseEntity.ok(orderId);
    }

    @GetMapping("/{id}/track")
    public ResponseEntity<ManufacturingOrderStatusDto> track(@PathVariable("id") UUID id) {
        ManufacturingOrderStatusDto status = manufacturingOrderStatusService.getManufacturingOrderStatus(id);
        return ResponseEntity.ok(status);
    }
}
