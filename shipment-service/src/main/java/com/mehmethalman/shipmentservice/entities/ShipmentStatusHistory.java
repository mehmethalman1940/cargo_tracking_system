package com.mehmethalman.shipmentservice.entities;

import com.mehmethalman.shipmentservice.enums.CourierStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipment_status_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "shipment_tracking_number", nullable = false, length = 50)
    private String shipmentTrackingNumber;


    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private CourierStatusType status;

    @Column(name = "changed_by_courier_id")
    private Long changedByCourierId;

    @Column(name = "changed_at", nullable = false, updatable = false)
    private LocalDateTime changedAt;

    @Column(name = "remarks", length = 255)
    private String remarks;

    @PrePersist
    protected void onCreate() {
        this.changedAt = LocalDateTime.now();
    }
}