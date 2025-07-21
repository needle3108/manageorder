package com.project.customerorder.adapter.in.rest;

import com.project.customerorder.application.command.CreateCustomerOrderCommand;
import com.project.customerorder.application.port.in.CreateCustomerOrderApplicationPort;
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
public class CustomerOrderRestController {
    private final CreateCustomerOrderApplicationPort createOrder;

    @PostMapping
    public ResponseEntity<UUID> createCustomerOrder(@RequestBody CreateCustomerOrderCommand command) {
        UUID orderId = createOrder.create(command);
        return ResponseEntity.ok(orderId);
    }
}
