package com.project.customerorder.adapter.out.persistence.entity;

import com.project.customerorder.domain.model.CustomerOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer_order")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderEntity {
    @Id
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private CustomerOrderStatus status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderLineEntity> lines;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CustomerOrderStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerOrderStatus status) {
        this.status = status;
    }

    public List<OrderLineEntity> getLines() {
        return lines;
    }

    public void setLines(List<OrderLineEntity> lines) {
        this.lines = lines;
    }
}
