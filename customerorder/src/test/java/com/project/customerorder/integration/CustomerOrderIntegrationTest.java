package com.project.customerorder.integration;

import com.project.customerorder.application.command.CreateCustomerOrderCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerOrderIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldCreateCustomerOrderAndReturnUuid() {
        CreateCustomerOrderCommand.OrderLineDto line = new CreateCustomerOrderCommand.OrderLineDto(
                UUID.randomUUID().toString(), 3
        );
        CreateCustomerOrderCommand command = new CreateCustomerOrderCommand(List.of(line));

        ResponseEntity<UUID> response = restTemplate.postForEntity(
                "/api/orders",
                command,
                UUID.class
        );

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();

        System.out.println("Created order id: " + response.getBody());
    }
}
