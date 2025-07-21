package com.project.customerorder.adapter.in.rest;

import com.project.customerorder.application.command.CreateCustomerOrderCommand;
import com.project.customerorder.application.port.in.CreateCustomerOrderApplicationPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerOrderRestControllerTest {
    @Mock
    private CreateCustomerOrderApplicationPort createOrder;

    @InjectMocks
    private CustomerOrderRestController controller;

    @Test
    void shouldCreateCustomerOrder() {
        UUID expectedId = UUID.randomUUID();

        CreateCustomerOrderCommand.OrderLineDto line = new CreateCustomerOrderCommand.OrderLineDto(
                UUID.randomUUID().toString(), 2
        );

        CreateCustomerOrderCommand command = new CreateCustomerOrderCommand(List.of(line));

        when(createOrder.create(command)).thenReturn(expectedId);

        ResponseEntity<UUID> response = controller.createCustomerOrder(command);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo(expectedId);
        verify(createOrder, times(1)).create(command);
    }
}
