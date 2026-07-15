package com.mehmethalman.courierservice.mapper;

import com.mehmethalman.courierservice.dto.CourierDto;
import com.mehmethalman.courierservice.entities.Courier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    CourierDto toDto(Courier courier);
    List<CourierDto> toDtoList(List<Courier> couriers);
}
