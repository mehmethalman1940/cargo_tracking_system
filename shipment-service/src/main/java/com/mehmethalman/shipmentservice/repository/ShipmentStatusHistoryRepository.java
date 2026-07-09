package com.mehmethalman.shipmentservice.repository;

import com.mehmethalman.shipmentservice.entities.ShipmentStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentStatusHistoryRepository  extends JpaRepository<ShipmentStatusHistory, Long> {
}
