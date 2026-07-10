package com.mehmethalman.shipmentservice.repository;

import com.mehmethalman.shipmentservice.entities.ShipmentStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentStatusHistoryRepository  extends JpaRepository<ShipmentStatusHistory, Long> {
    List<ShipmentStatusHistory> findAllByShipmentTrackingNumberOrderByChangedAtDesc(String trackingNumber);}
