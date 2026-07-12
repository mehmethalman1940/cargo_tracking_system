package com.mehmethalman.courierservice.service;

import com.mehmethalman.courierservice.dto.CourierDto;
import com.mehmethalman.courierservice.entities.Courier;
import com.mehmethalman.courierservice.mapper.CourierMapper;
import com.mehmethalman.courierservice.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourierService {
    private final CourierRepository courierRepository;

    private final CourierMapper courierMapper;

    public List<CourierDto> getIsAvaibleCourier() {
        List<Courier> couriers = courierRepository.findAllByIsAvailableTrue();
        if (couriers.isEmpty()) {
            throw new RuntimeException("Müsait kurye yoktur.");
        }
        return courierMapper.toDtoList(couriers);

    }
}
