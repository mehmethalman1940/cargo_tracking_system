package com.mehmethalman.notificationservice.kafka;

import com.mehmethalman.notificationservice.event.ShipmentStatusChangedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@RequiredArgsConstructor
@Service
public class ShipmentConsumer {
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "shipment-status-changed", groupId = "notification-group")
    public void consumeStatusChangedEvent(String message){

        ShipmentStatusChangedEvent event = objectMapper.readValue(message, ShipmentStatusChangedEvent.class);
        System.out.println("Kargo Takip No: " + event.getTrackingNumber());
        System.out.println("Yeni Durum: " + event.getStatus());
        System.out.println("Alıcı: " + event.getReceiverName());

    }
}
