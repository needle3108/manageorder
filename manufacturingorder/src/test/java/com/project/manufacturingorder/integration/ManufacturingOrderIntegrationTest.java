package com.project.manufacturingorder.integration;

import com.project.manufacturingorder.application.command.CreateManufacturingOrderCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManufacturingOrderIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldCreateManufacturingOrderAndReturnUuid() {
        CreateManufacturingOrderCommand command = new CreateManufacturingOrderCommand();

        ResponseEntity<UUID> response = restTemplate.postForEntity(
                "/api/orders",
                command,
                UUID.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();

        System.out.println("Created order id: " + response.getBody());
    }
}
