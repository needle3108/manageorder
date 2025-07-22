package com.project.customerorder.adapter.config;

import com.project.customerorder.adapter.out.external.ManufacturingOrderStatusAdapter;
import com.project.customerorder.domain.port.out.ManufacturingOrderStatusPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CustomerOrderBeanConfig {
    @Bean
    public WebClient manufacturingOrderWebClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8082/api/orders").build();
    }

    @Bean
    public ManufacturingOrderStatusPort manufacturingOrderStatusPort(WebClient manufacturingOrderWebClient) {
        return new ManufacturingOrderStatusAdapter(manufacturingOrderWebClient);
    }
}
