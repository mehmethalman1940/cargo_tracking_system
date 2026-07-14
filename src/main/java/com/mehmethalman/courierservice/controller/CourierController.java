package com.mehmethalman.courierservice.controller;

import com.mehmethalman.courierservice.dto.CourierAssignRequestDto;
import com.mehmethalman.courierservice.dto.CourierDto;
import com.mehmethalman.courierservice.service.CourierService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get")
    public List<CourierDto> getAllCouriers(){
        return courierService.getAllCourier();
    }

    @PostMapping(path = "/{id}/assign")
    public ResponseEntity<String> assignCourier(@PathVariable Long id, @RequestBody CourierAssignRequestDto courierAssignRequestDto) {
        courierService.assignCourier(id, courierAssignRequestDto);
        return ResponseEntity.ok("Kurye başarıyla kargoya atandı ve false durumuna getirildi.");
    }
}
