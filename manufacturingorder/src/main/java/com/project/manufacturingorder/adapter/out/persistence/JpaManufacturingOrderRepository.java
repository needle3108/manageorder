package com.project.manufacturingorder.adapter.out.persistence;

import com.project.manufacturingorder.domain.model.ManufacturingOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaManufacturingOrderRepository extends JpaRepository<ManufacturingOrderEntity, UUID> {
}
