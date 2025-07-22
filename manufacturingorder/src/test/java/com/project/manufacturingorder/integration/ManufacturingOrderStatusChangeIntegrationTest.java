package com.project.manufacturingorder.integration;

import com.project.manufacturingorder.adapter.in.rest.ChangeStatusDto;
import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import com.project.manufacturingorder.domain.model.ManufacturingOrderId;
import com.project.manufacturingorder.domain.model.ManufacturingOrderStatus;
import com.project.manufacturingorder.domain.port.out.ManufacturingOrderRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManufacturingOrderStatusChangeIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ManufacturingOrderRepositoryPort repository;

    private UUID orderId;

    @BeforeEach
    void setup() {
        orderId = UUID.randomUUID();
        ManufacturingOrder order = new ManufacturingOrder(
                new ManufacturingOrderId(orderId),
                ManufacturingOrderStatus.CREATED
        );
        repository.save(order);
    }

    @Test
    void shouldChangeManufacturingOrderStatus() {
        ChangeStatusDto dto = new ChangeStatusDto(ManufacturingOrderStatus.CONFIRMED);

        ResponseEntity<Void> response = restTemplate.exchange(
                "/api/orders/{id}/status",
                HttpMethod.PATCH,
                new HttpEntity<>(dto),
                Void.class,
                orderId
        );

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        ManufacturingOrder updatedOrder = repository.findById(orderId).orElseThrow();
        assertEquals(ManufacturingOrderStatus.CONFIRMED, updatedOrder.getStatus());
    }
}
