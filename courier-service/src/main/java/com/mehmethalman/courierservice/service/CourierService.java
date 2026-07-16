package com.mehmethalman.courierservice.service;

import com.mehmethalman.courierservice.dto.CourierAssignRequestDto;
import com.mehmethalman.courierservice.dto.CourierDto;
import com.mehmethalman.courierservice.entities.Courier;
import com.mehmethalman.courierservice.entities.CourierAssignment;
import com.mehmethalman.courierservice.enums.Status;
import com.mehmethalman.courierservice.mapper.CourierMapper;
import com.mehmethalman.courierservice.repository.CourierAssignmentRepository;
import com.mehmethalman.courierservice.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourierService {
    private final CourierRepository courierRepository;
    private final CourierAssignmentRepository courierAssignmentRepository;
    private final CourierMapper courierMapper;

    public List<CourierDto> getIsAvaibleCourier() {
        List<Courier> couriers = courierRepository.findAllByIsAvailableTrue();
        if (couriers.isEmpty()) {
            throw new RuntimeException("Müsait kurye yoktur.");
        }
        return courierMapper.toDtoList(couriers);
    }

    public List<CourierDto> getAllCourier() {
        List<Courier> couriers = courierRepository.findAll();
        return courierMapper.toDtoList(couriers);
    }

    @org.springframework.transaction.annotation.Transactional
    public void assignCourier(Long courierId, CourierAssignRequestDto requestDto) {

        Courier courier = courierRepository.findById(courierId).orElseThrow();
        if (courier == null) {
            throw new RuntimeException("böyle bir kurye yok id: " + courierId);
        }
        if (!courier.isAvailable()) {
            throw new RuntimeException("Bu kurye şu an başka bir teslimatta lütfen müsait bir kurye seçin");
        }
        courier.setAvailable(false);
        courierRepository.save(courier);

        CourierAssignment assignment = new CourierAssignment();
        assignment.setCourierId(courierId);
        assignment.setShipmentTrackingNumber(requestDto.getShipmentTrackingNumber());
        assignment.setAssignedAt(LocalDateTime.now());
        assignment.setStatus(Status.ASSIGNED);

        courierAssignmentRepository.save(assignment);

        //2. kafka mesajını buraya yazacağım unutma !!!
        System.out.println(" Kurye " + courier.getFullName() + ", " + requestDto.getShipmentTrackingNumber() + " nolu kargoya atanmıştır.");
    }


}
