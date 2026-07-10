package com.mehmethalman.shipmentservice.dto;

import lombok.Data;

@Data
public class UpdateShipmentStatusDto {
    private String status;
    private String remarks;
}