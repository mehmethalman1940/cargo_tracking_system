package com.mehmethalman.notificationservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehmethalman.notificationservice.event.ShipmentStatusChangedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ShipmentConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = "shipment-status-changed", groupId = "notification-group-v2")
    public void consumeStatusChangedEvent(String message) {
        try {
            ShipmentStatusChangedEvent event = objectMapper.readValue(message, ShipmentStatusChangedEvent.class);

            System.out.println("🚀 [Notification Service] Kafka'dan Mesaj Başarıyla Alındı!");
            System.out.println("Kargo Takip No: " + event.getTrackingNumber());
            System.out.println("Yeni Durum: " + event.getStatus());
            System.out.println("Alıcı: " + event.getReceiverName());
            System.out.println("----------------------------------------------");

        } catch (JsonProcessingException e) {
            System.err.println("❌ JSON Dönüşüm Hatası! Ham Mesaj: " + message);
            e.printStackTrace();
        }
    }
}