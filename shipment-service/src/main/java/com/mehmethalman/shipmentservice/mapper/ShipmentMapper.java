package com.mehmethalman.shipmentservice.mapper;
import com.mehmethalman.shipmentservice.dto.ShipmentDto;
import com.mehmethalman.shipmentservice.dto.ShipmentDtoUı;
import com.mehmethalman.shipmentservice.dto.ShipmentStatusHistoryDto;
import com.mehmethalman.shipmentservice.entities.Shipment;
import com.mehmethalman.shipmentservice.entities.ShipmentStatusHistory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    ShipmentDto toDto(Shipment shipment);

    Shipment toEntity(ShipmentDtoUı shipmentDtoUı);
    Shipment toEntity(ShipmentDto shipmentDto);
    List<ShipmentDto> toDtoList(List<Shipment> shipments);
    ShipmentStatusHistoryDto toStatusHistoryDto(ShipmentStatusHistory history);
    List<ShipmentStatusHistoryDto> toStatusHistoryDtoList(List<ShipmentStatusHistory> historyList);}
