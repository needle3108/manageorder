package com.project.manufacturingorder.adapter.in.rest;

import com.project.manufacturingorder.domain.model.ManufacturingOrderStatus;

public record ChangeStatusDto(ManufacturingOrderStatus status) {
}
