package com.project.manufacturingorder.adapter.config;

import com.project.manufacturingorder.application.mapper.ManufacturingOrderMapper;
import com.project.manufacturingorder.application.port.in.CreateManufacturingOrderApplicationPort;
import com.project.manufacturingorder.application.service.ManufacturingOrderApplicationService;
import com.project.manufacturingorder.domain.port.out.ManufacturingOrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufacturingOrderBeanConfig {
    @Bean
    public CreateManufacturingOrderApplicationPort createManufacturingOrderApplicationPort(
            ManufacturingOrderRepositoryPort repository,
            ManufacturingOrderMapper mapper
    ) {
        return new ManufacturingOrderApplicationService(repository, mapper);
    }
}
