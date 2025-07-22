package com.project.manufacturingorder.adapter.out.persistence;

import com.project.manufacturingorder.adapter.out.persistence.mapper.ManufacturingOrderPersistenceMapper;
import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import com.project.manufacturingorder.domain.port.out.ManufacturingOrderRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturingOrderRepository implements ManufacturingOrderRepositoryPort {
    private final JpaManufacturingOrderRepository jpaRepository;
    private final ManufacturingOrderPersistenceMapper mapper;

    public ManufacturingOrderRepository(JpaManufacturingOrderRepository jpaRepository, ManufacturingOrderPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(ManufacturingOrder order) {
        var entity = mapper.toEntity(order);
        jpaRepository.save(entity);
    }
}
