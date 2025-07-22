package com.project.manufacturingorder.adapter.out.persistence.entity;

import com.project.manufacturingorder.domain.model.ManufacturingOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "manufacturing_order")
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturingOrderEntity {
    @Id
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ManufacturingOrderStatus status;

    public ManufacturingOrderStatus getStatus() {
        return status;
    }

    public UUID getId() {
        return id;
    }

    public void setStatus(ManufacturingOrderStatus status) {
        this.status = status;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
