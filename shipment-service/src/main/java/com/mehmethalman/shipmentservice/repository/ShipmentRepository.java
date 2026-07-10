package com.mehmethalman.shipmentservice.repository;

import com.mehmethalman.shipmentservice.entities.Shipment;
import com.mehmethalman.shipmentservice.entities.ShipmentStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
    Shipment findByTrackingNumber(String trackingNumber);
}
