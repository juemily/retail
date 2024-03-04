package com.example.retail.infrastructure.mapper;

import com.example.retail.domain.model.dto.Price;
import com.example.retail.infrastructure.dbo.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RetailMapper {

    RetailMapper INSTANCE = Mappers.getMapper(RetailMapper.class);

    Price toDto(PriceEntity entity);
    Price toDto(PriceEntity entity, Set<String> attributesToMap);
    PriceEntity toEntity(Price resouce );


}
