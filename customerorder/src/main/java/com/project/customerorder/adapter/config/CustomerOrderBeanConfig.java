package com.project.customerorder.adapter.config;

import com.project.customerorder.application.mapper.CustomerOrderMapper;
import com.project.customerorder.application.port.in.CreateCustomerOrderApplicationPort;
import com.project.customerorder.application.service.CustomerOrderApplicationService;
import com.project.customerorder.domain.port.out.CustomerOrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerOrderBeanConfig {
    @Bean
    public CreateCustomerOrderApplicationPort createCustomerOrderApplicationPort(
            CustomerOrderRepositoryPort repository,
            CustomerOrderMapper mapper
    ) {
        return new CustomerOrderApplicationService(repository, mapper);
    }
}
