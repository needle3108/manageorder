package com.project.customerorder.adapter.out.persistence;

import com.project.customerorder.domain.model.CustomerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCustomerOrderRepository extends JpaRepository<CustomerOrderEntity, UUID>{
}
