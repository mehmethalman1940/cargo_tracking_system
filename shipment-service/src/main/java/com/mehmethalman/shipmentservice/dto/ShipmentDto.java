package com.mehmethalman.shipmentservice.dto;

import com.mehmethalman.shipmentservice.enums.CourierStatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShipmentDto {

    private String id;

    private String trackingNumber;

    private String senderAddress;

    private String receiverAddress;

    private Long assignedCourierId;

    private LocalDateTime createdAt;
}
