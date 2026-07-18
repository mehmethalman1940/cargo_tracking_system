package com.mehmethalman.notificationservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentStatusChangedEvent {
    private String trackingNumber;
    private String status;
    private String receiverName;
    private String receiverAddress;
}