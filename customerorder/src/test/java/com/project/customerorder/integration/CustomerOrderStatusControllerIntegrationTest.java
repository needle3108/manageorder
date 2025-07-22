package com.project.customerorder.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class CustomerOrderStatusControllerIntegrationTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    void shouldReturnStatusFromManufacturingOrder() {
        UUID orderId = UUID.fromString("bdd93923-7b90-4dbf-be6a-c9f7f653ace8");

        webClient.get()
                .uri("/api/orders/{id}/track", orderId)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(orderId.toString())
                .jsonPath("$.status").isEqualTo("CREATED");
    }
}
