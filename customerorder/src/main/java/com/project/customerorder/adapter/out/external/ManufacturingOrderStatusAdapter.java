package com.project.customerorder.adapter.out.external;

import com.project.customerorder.domain.model.ManufacturingOrderStatusDto;
import com.project.customerorder.domain.port.out.ManufacturingOrderStatusPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Component
@Primary
@RequiredArgsConstructor
public class ManufacturingOrderStatusAdapter implements ManufacturingOrderStatusPort {
    private final WebClient webClient;

    @Override
    public ManufacturingOrderStatusDto getStatus(UUID orderId) {
        return webClient.get()
                .uri("/{id}/status", orderId)
                .retrieve()
                .bodyToMono(ManufacturingOrderStatusDto.class)
                .block();
    }
}
