package com.project.manufacturingorder.adapter.config;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        collectionMappingStrategy = CollectionMappingStrategy.ACCESSOR_ONLY,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface MapStructConfig {
}
