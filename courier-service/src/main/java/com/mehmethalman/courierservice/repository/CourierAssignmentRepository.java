package com.mehmethalman.courierservice.repository;

import com.mehmethalman.courierservice.entities.CourierAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierAssignmentRepository extends JpaRepository<CourierAssignment, Long> {

}
