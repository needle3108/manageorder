package com.project.manufacturingorder.adapter.out.persistence.mapper;

import com.project.manufacturingorder.adapter.config.MapStructConfig;
import com.project.manufacturingorder.domain.model.ManufacturingOrderEntity;
import com.project.manufacturingorder.domain.model.ManufacturingOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ManufacturingOrderPersistenceMapper {
    @Mapping(target = "id", source = "id.value")
    @Mapping(target = "status", source = "status")
    ManufacturingOrderEntity toEntity(ManufacturingOrder domain);

    @Mapping(target = "id", expression = "java(new ManufacturingOrderId(entity.getId()))")
    @Mapping(target = "status", source = "status")
    ManufacturingOrder toDomain(ManufacturingOrderEntity entity);
}
