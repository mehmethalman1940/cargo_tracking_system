package com.mehmethalman.shipmentservice.controller;

import com.mehmethalman.shipmentservice.dto.ShipmentDto;
import com.mehmethalman.shipmentservice.dto.ShipmentDtoUı;
import com.mehmethalman.shipmentservice.dto.ShipmentStatusHistoryDto;
import com.mehmethalman.shipmentservice.dto.UpdateShipmentStatusDto;
import com.mehmethalman.shipmentservice.services.ShipmentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/shipment")
public class ShipmentController {
    private final ShipmentService shipmentService;

    @PostMapping(path = "/save")
    public ShipmentDto createShipment(@RequestBody ShipmentDtoUı shipmentDtoUı) {
        return shipmentService.createShipment(shipmentDtoUı);
    }

    @GetMapping(path = "/get")
    public List<ShipmentDto> findAll() {
        return shipmentService.getAllShipments();
    }

    @GetMapping(path = "/trackingNumber/{trackingNumber}")
    public ShipmentDto findAllByTrackingNumber(@PathVariable String trackingNumber) {
        return shipmentService.getShipmentBytrackingNumber(trackingNumber);
    }
    @GetMapping(path = "/{trackingNumber}/history")
    public List<ShipmentStatusHistoryDto> getShipmentHistoryByTrackingNumber(@PathVariable String trackingNumber) {
        return shipmentService.getShipmentHistoryByTrackingNumber(trackingNumber);
    }

    @PatchMapping(path = "/{trackingNumber}/status")
    public ResponseEntity<String> updateShipmentStatus(
            @PathVariable String trackingNumber,
            @RequestBody UpdateShipmentStatusDto requestDto) {

        shipmentService.updateShipmentStatus(trackingNumber, requestDto);

        return ResponseEntity.ok("Kargo statüsü başarıyla güncellendi (Geçmişe işlendi) ve Kafka eventi tetiklendi.");
    }

    @PostMapping("/{trackingNumber}/assign")
    public ResponseEntity<String> assignCourier(@PathVariable String trackingNumber, @RequestParam Long courierId) {

        shipmentService.assignShipmentToCourier(courierId, trackingNumber);
        return ResponseEntity.ok("Kurye atama işlemi kargo servisi üzerinden başarıyla başlatıldı!");
    }
}
