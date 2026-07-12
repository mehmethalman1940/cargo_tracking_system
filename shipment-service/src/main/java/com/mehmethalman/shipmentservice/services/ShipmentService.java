package com.mehmethalman.shipmentservice.services;

import com.mehmethalman.shipmentservice.dto.ShipmentDto;
import com.mehmethalman.shipmentservice.dto.ShipmentDtoUı;
import com.mehmethalman.shipmentservice.dto.ShipmentStatusHistoryDto;
import com.mehmethalman.shipmentservice.dto.UpdateShipmentStatusDto;
import com.mehmethalman.shipmentservice.entities.Shipment;
import com.mehmethalman.shipmentservice.entities.ShipmentStatusHistory;
import com.mehmethalman.shipmentservice.enums.CourierStatusType;
import com.mehmethalman.shipmentservice.mapper.ShipmentMapper;
import com.mehmethalman.shipmentservice.repository.ShipmentRepository;
import com.mehmethalman.shipmentservice.repository.ShipmentStatusHistoryRepository;
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
    private final ShipmentStatusHistoryRepository shipmentStatusHistoryRepository;

    public ShipmentDto createShipment(ShipmentDtoUı shipmentDtoUı) {
        Shipment shipment = shipmentMapper.toEntity(shipmentDtoUı);
        shipment.setId(UUID.randomUUID().toString());
        shipment.setTrackingNumber(UUID.randomUUID().toString());
        Shipment savedShipment = shipmentRepository.save(shipment);
        return shipmentMapper.toDto(savedShipment);
    }

    public ShipmentDto getShipmentBytrackingNumber(String trackingNumber) {
        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber);
        if (shipment == null) {
            System.out.println("Found shipment");
        }
        return shipmentMapper.toDto(shipment);
    }

    public List<ShipmentDto> getAllShipments() {
        List<Shipment> shipments = shipmentRepository.findAll();
        return shipmentMapper.toDtoList(shipments);
    }

    public List<ShipmentStatusHistoryDto> getShipmentHistoryByTrackingNumber(String trackingNumber) {
        List<ShipmentStatusHistory> historyList = shipmentStatusHistoryRepository.findAllByShipmentTrackingNumberOrderByChangedAtDesc(trackingNumber);

        if (historyList.isEmpty()) {
            throw new RuntimeException("Bu Tracking number yok: " + trackingNumber);
        }
        return shipmentMapper.toStatusHistoryDtoList(historyList);
    }

    @org.springframework.transaction.annotation.Transactional
    public void updateShipmentStatus(String trackingNumber, UpdateShipmentStatusDto requestDto) {

        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber);
        if (shipment == null) {
            throw new RuntimeException("Statüsü güncellenmek istenen kargo bulunamadı: " + trackingNumber);
        }

        ShipmentStatusHistory history = new ShipmentStatusHistory();
        history.setShipmentTrackingNumber(trackingNumber);

        history.setStatus(CourierStatusType.valueOf(requestDto.getStatus().toUpperCase()));
        history.setRemarks(requestDto.getRemarks());

        shipmentStatusHistoryRepository.save(history);

    }
    }


