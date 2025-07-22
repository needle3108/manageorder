package com.project.manufacturingorder.adapter.in.rest;

import com.project.manufacturingorder.application.command.CreateManufacturingOrderCommand;
import com.project.manufacturingorder.application.port.in.CreateManufacturingOrderApplicationPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ManufacturingOrderRestControllerTest {
    @Mock
    private CreateManufacturingOrderApplicationPort createOrder;

    @InjectMocks
    private ManufacturingOrderRestController controller;

    @Test
    void shouldCreateManufacturingOrder() {
        UUID expectedId = UUID.randomUUID();

        CreateManufacturingOrderCommand command = new CreateManufacturingOrderCommand();

        when(createOrder.create(command)).thenReturn(expectedId);

        ResponseEntity<UUID> response = controller.createManufacturingOrder(command);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo(expectedId);
        verify(createOrder, times(1)).create(command);
    }
}
