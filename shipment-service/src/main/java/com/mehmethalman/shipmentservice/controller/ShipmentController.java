package com.mehmethalman.shipmentservice.controller;

import com.mehmethalman.shipmentservice.dto.ShipmentDto;
import com.mehmethalman.shipmentservice.dto.ShipmentDtoUı;
import com.mehmethalman.shipmentservice.services.ShipmentService;
import lombok.RequiredArgsConstructor;
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
}
