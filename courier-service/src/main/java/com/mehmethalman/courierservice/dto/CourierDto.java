package com.mehmethalman.courierservice.dto;

import com.mehmethalman.courierservice.enums.VehicleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourierDto {
    private Long id;

    private String fullName;

    private String phone;

    private VehicleEnum vehicleType;

    private boolean isAvailable = true;
}
