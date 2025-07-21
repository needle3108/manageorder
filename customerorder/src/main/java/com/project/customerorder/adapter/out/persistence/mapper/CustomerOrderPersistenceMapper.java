package com.project.customerorder.adapter.out.persistence.mapper;

import com.project.customerorder.adapter.config.MapStructConfig;
import com.project.customerorder.adapter.out.persistence.entity.CustomerOrderEntity;
import com.project.customerorder.adapter.out.persistence.entity.OrderLineEntity;
import com.project.customerorder.domain.model.CustomerOrder;
import com.project.customerorder.domain.model.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface CustomerOrderPersistenceMapper {
    @Mapping(target = "id", source = "id.value")
    @Mapping(target = "lines", source = "orderLines")
    @Mapping(target = "status", source = "status")
    CustomerOrderEntity toEntity(CustomerOrder domain);

    @Mapping(target = "id", expression = "java(new CustomerOrderId(entity.getId()))")
    @Mapping(target = "orderLines", source = "lines")
    @Mapping(target = "status", source = "status")
    CustomerOrder toDomain(CustomerOrderEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productId", source = "productId.value")
    OrderLineEntity toEntity(OrderLine domain);

    @Mapping(target = "productId", expression = "java(new ProductId(entity.getProductId()))")
    OrderLine toDomain(OrderLineEntity entity);

    List<OrderLineEntity> toEntity(List<OrderLine> domain);

    List<OrderLine> toDomain(List<OrderLineEntity> entity);
}
