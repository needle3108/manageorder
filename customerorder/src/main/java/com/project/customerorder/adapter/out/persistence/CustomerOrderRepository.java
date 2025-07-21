package com.project.customerorder.adapter.out.persistence;

import com.project.customerorder.adapter.out.persistence.mapper.CustomerOrderPersistenceMapper;
import com.project.customerorder.domain.model.CustomerOrder;
import com.project.customerorder.domain.port.out.CustomerOrderRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerOrderRepository implements CustomerOrderRepositoryPort {
    private final JpaCustomerOrderRepository jpaRepository;
    private final CustomerOrderPersistenceMapper mapper;

    public CustomerOrderRepository(JpaCustomerOrderRepository jpaRepository, CustomerOrderPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(CustomerOrder order) {
        var entity = mapper.toEntity(order);
        jpaRepository.save(entity);
    }
}
