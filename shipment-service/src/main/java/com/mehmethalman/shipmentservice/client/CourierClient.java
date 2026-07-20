package com.mehmethalman.shipmentservice.client;

import com.mehmethalman.shipmentservice.dto.CourierAssignRequestDto;
import com.mehmethalman.shipmentservice.exception.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "courier-service", url = "http://localhost:8082/api/couriers", configuration = CustomErrorDecoder.class)
public interface CourierClient {

    @PostMapping("/{id}/assign")
    String assignCourier(@PathVariable("id") Long id, @RequestBody CourierAssignRequestDto requestDto);
}