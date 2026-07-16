package com.mehmethalman.shipmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentStatusHistoryDto {

    private String id;
    private String shipmentId;
    private String status;
    private LocalDateTime changedAt;
    private String description;
}