package com.project.customerorder.application.mapper;

import com.project.customerorder.adapter.config.MapStructConfig;
import com.project.customerorder.application.command.CreateCustomerOrderCommand;
import com.project.customerorder.domain.model.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(config = MapStructConfig.class)
public interface CustomerOrderMapper {

    default CustomerOrder toDomain(CreateCustomerOrderCommand command) {
        CustomerOrderId id = new CustomerOrderId(UUID.randomUUID());
        List<OrderLine> orderLines = orderLinesFromDto(command.lines());
        return new CustomerOrder(id, orderLines, CustomerOrderStatus.CREATED);
    }

    default List<OrderLine> orderLinesFromDto(List<CreateCustomerOrderCommand.OrderLineDto> dtos) {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(this::toDomain)
                .toList();
    }

    default OrderLine toDomain(CreateCustomerOrderCommand.OrderLineDto dto) {
        return new OrderLine(new ProductId(dto.productId()), dto.quantity());
    }
}
