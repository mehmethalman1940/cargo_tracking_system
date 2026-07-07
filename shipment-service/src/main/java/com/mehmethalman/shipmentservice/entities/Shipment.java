package com.mehmethalman.shipmentservice.entities;

import com.mehmethalman.shipmentservice.enums.CourierStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.UUID;

@Entity
@Table(name = "shipment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // BIGINT/BIGSERIAL ile tam uyumlu
    private Long id;

    @Column(name = "tracking_number", unique = true, nullable = false, length = 50)
    private String trackingNumber;

    @Column(name = "sender_address", nullable = false, length = 500)
    private String senderAddress;

    @Column(name = "receiver_address", nullable = false, length = 500)
    private String receiverAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "courier_status_type", nullable = false, length = 30)
    private CourierStatusType courierStatus;

    @Column(name = "assigned_courier_id")
    private Long assignedCourierId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
