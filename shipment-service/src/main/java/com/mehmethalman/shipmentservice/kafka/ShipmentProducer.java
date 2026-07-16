package com.mehmethalman.shipmentservice.kafka;

import com.mehmethalman.shipmentservice.event.ShipmentStatusChangedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShipmentProducer {

    private final KafkaTemplate<String, ShipmentStatusChangedEvent> kafkaTemplate;

    public ShipmentProducer(KafkaTemplate<String, ShipmentStatusChangedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishStatusChangedEvent(ShipmentStatusChangedEvent event) {
        System.out.println("Kafka'ya event gönderiliyor Takip No: " + event.getTrackingNumber() + "Yeni Durum: " + event.getStatus());

        kafkaTemplate.send("shipment-status-changed", event.getTrackingNumber(), event);

        System.out.println("Event başarıyla Kafka otobanına fırlatıldı");
    }
}