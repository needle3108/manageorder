package com.project.manufacturingorder.application.mapper;

import com.project.manufacturingorder.adapter.config.MapStructConfig;
import com.project.manufacturingorder.application.command.CreateManufacturingOrderCommand;
import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import com.project.manufacturingorder.domain.model.ManufacturingOrderStatus;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface ManufacturingOrderMapper {

    default ManufacturingOrder toDomain(CreateManufacturingOrderCommand command) {
        return new ManufacturingOrder(ManufacturingOrderStatus.CREATED);
    }
}
