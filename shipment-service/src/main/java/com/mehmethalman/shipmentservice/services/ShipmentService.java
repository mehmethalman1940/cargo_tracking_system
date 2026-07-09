package com.mehmethalman.shipmentservice.services;

import com.mehmethalman.shipmentservice.dto.ShipmentDto;
import com.mehmethalman.shipmentservice.dto.ShipmentDtoUı;
import com.mehmethalman.shipmentservice.entities.Shipment;
import com.mehmethalman.shipmentservice.mapper.ShipmentMapper;
import com.mehmethalman.shipmentservice.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final ShipmentMapper shipmentMapper;

    public ShipmentDto createShipment(ShipmentDtoUı shipmentDtoUı) {
        Shipment shipment = shipmentMapper.toEntity(shipmentDtoUı);
        shipment.setId(UUID.randomUUID().toString());
        shipment.setTrackingNumber(UUID.randomUUID().toString());
        Shipment savedShipment = shipmentRepository.save(shipment);
        return shipmentMapper.toDto(savedShipment);
    }

    public ShipmentDto getShipmentBytrackingNumber(String trackingNumber) {
        Optional<Shipment> shipmentOptional = shipmentRepository.findByTrackingNumber(trackingNumber);
        if (shipmentOptional.isPresent()) {
            System.out.println("Found shipment");
        }
        return shipmentMapper.toDto(shipmentOptional.get());
    }

    public List<ShipmentDto> getAllShipments() {
        List<Shipment> shipments = shipmentRepository.findAll();
        return shipmentMapper.toDtoList(shipments);
    }
    }


