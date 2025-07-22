package com.project.manufacturingorder.domain.model;

import java.util.UUID;

public record ManufacturingOrderId(UUID value){
    public static ManufacturingOrderId random() {
        return new ManufacturingOrderId(UUID.randomUUID());
    }
}
