package com.mehmethalman.shipmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDtoUı {
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private String status;
}