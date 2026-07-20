package com.mehmethalman.shipmentservice.event;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentStatusChangedEvent {
    private String trackingNumber;
    private String status;
    private String receiverName;
    private String receiverAddress;
}
