package com.mehmethalman.shipmentservice.mapper;
import com.mehmethalman.shipmentservice.dto.ShipmentDto;
import com.mehmethalman.shipmentservice.dto.ShipmentDtoUı;
import com.mehmethalman.shipmentservice.entities.Shipment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    ShipmentDto toDto(Shipment shipment);

    Shipment toEntity(ShipmentDtoUı shipmentDtoUı);
    Shipment toEntity(ShipmentDto shipmentDto);
    List<ShipmentDto> toDtoList(List<Shipment> shipments);
}
