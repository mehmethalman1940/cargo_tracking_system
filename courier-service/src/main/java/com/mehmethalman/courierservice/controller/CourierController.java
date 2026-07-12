package com.mehmethalman.courierservice.controller;

import com.mehmethalman.courierservice.dto.CourierDto;
import com.mehmethalman.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/couriers")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService courierService;

    @GetMapping("/available")
    public ResponseEntity<List<CourierDto>> getAvailableCouriers() {
        List<CourierDto> availableCouriers = courierService.getIsAvaibleCourier();
        return ResponseEntity.ok(availableCouriers);
    }
}
